package com.home.sambit.framework.workflow;

import java.util.List;

public class DefaultWorkflow implements Workflow {
	List<Task> tasks;
	DecisionTask decision;
	public void executeFlow() {
		for (Task eachTask : tasks) {
			eachTask.execute();
		}
		if(decision!=null){
			decision.evaluate().executeFlow();
		}
	}
}
