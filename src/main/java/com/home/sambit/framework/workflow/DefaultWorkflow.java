package com.home.sambit.framework.workflow;

import java.util.List;

public class DefaultWorkflow implements Workflow {
	List<Task> tasks;
	DecisionBox decisionBox;
	MergeBox mergeBox;
	String name;

	public void execute() {
		for (Task eachTask : tasks) {
			eachTask.execute();
		}
		if (decisionBox != null) {
			decisionBox.evaluate().execute();
		} 
		if(mergeBox != null ){
			mergeBox.execute();
		}
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void setDecisionBox(DecisionBox decisionBox) {
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