package com.home.sambit.framework.workflow;

import java.util.List;

public class DefaultWorkflow<PAYLOAD> implements Workflow<PAYLOAD> {
	List<Task<PAYLOAD>> tasks;
	DecisionBox<PAYLOAD> decisionBox;
	MergeBox mergeBox;
	String name;

	public void execute(PAYLOAD payload) {
		for (Task<PAYLOAD> eachTask : tasks) {
			eachTask.execute(payload,null);
		}
		if (decisionBox != null) {
			decisionBox.evaluate(payload).execute(payload);
		} 
		if(mergeBox != null ){
			mergeBox.execute();
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

	public void setMergeBox(MergeBox mergeBox) {
		this.mergeBox = mergeBox;
	}
}