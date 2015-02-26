package com.home.sambit.framework.workflow;

import java.util.List;

public class DefaultWorkflow implements Workflow {
	List<Task> tasks;
	DecisionBox decision;
	String name;
	public void executeFlow() {
		for (Task eachTask : tasks) {
			eachTask.execute();
		}
		if(decision!=null){
			decision.evaluate().executeFlow();
		}
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public void setDecision(DecisionBox decision) {
		this.decision = decision;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}