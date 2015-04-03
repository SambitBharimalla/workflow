package com.home.sambit.framework.workflow;

import java.util.List;
import java.util.Set;

import com.home.sambit.framework.workflow.api.ControlKey;
import com.home.sambit.framework.workflow.api.DecisionBox;
import com.home.sambit.framework.workflow.api.MergeBox;
import com.home.sambit.framework.workflow.api.Task;
import com.home.sambit.framework.workflow.api.Workflow;

public class DefaultWorkflow<PAYLOAD> implements Workflow<PAYLOAD> {
	List<Task<PAYLOAD>> tasks;
	DecisionBox<PAYLOAD> decisionBox;
	MergeBox<PAYLOAD> mergeBox;
	String name;

	public void execute(PAYLOAD payload) {
		execute(payload, new TaskResult());
	}

	public void execute(PAYLOAD payload, TaskResult ongoingResult){
		for (Task<PAYLOAD> eachTask : tasks) {
			AbstractTask<PAYLOAD> abstractTask = (AbstractTask<PAYLOAD>) eachTask;
			abstractTask.execute(payload,ongoingResult);
			Set<ControlKey<?>> keysGeneratedByTask = ongoingResult.tempStorage.keySet();
			// Authorization Control
			for (ControlKey<?> keySet : keysGeneratedByTask) {
				if(!abstractTask.allowedPermissionOnKeys().containsKey(keySet)){
					System.out.println("Warning !! Task " + abstractTask.name + " accessing " + keySet.toString() + " without permission");
				}
			}
			ongoingResult.finalPublish();
		}
		if (decisionBox != null) {
			decisionBox.evaluate(payload, ongoingResult).execute(payload, ongoingResult);
		} 
		if(mergeBox != null ){
			mergeBox.execute(payload, ongoingResult);
		}
	}
	public void setTasks(List<Task<PAYLOAD>> tasks) {
		this.tasks = tasks;
	}

	public void setDecisionBox(DecisionBox<PAYLOAD> decisionBox) {
		this.decisionBox = decisionBox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMergeBox(MergeBox<PAYLOAD> mergeBox) {
		this.mergeBox = mergeBox;
	}
}