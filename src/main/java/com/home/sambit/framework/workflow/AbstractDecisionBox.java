package com.home.sambit.framework.workflow;

import java.util.List;

public abstract class AbstractDecisionBox<PAYLOAD> implements DecisionBox<PAYLOAD> {
	protected List<Workflow<PAYLOAD>> branches;

	public void setBranches(List<Workflow<PAYLOAD>> branches) {
		this.branches = branches;
	}
	public Workflow<PAYLOAD> getWorkflowByName(String workflowName){
		for(Workflow<PAYLOAD> workflow:branches){
			DefaultWorkflow<PAYLOAD> defaultworkflow = (DefaultWorkflow<PAYLOAD>) workflow;
			if(defaultworkflow.getName().equals(workflowName)){
				return defaultworkflow;
			}
		}
		return null;
	}
}