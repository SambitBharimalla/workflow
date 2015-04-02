package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.AbstractDecisionBox;
import com.home.sambit.framework.workflow.TaskResult;
import com.home.sambit.framework.workflow.Workflow;

public class DecisionA<PAYLOAD extends RequestPayload> extends AbstractDecisionBox<PAYLOAD> {
	public Workflow<PAYLOAD> evaluate(PAYLOAD payload, TaskResult taskResult) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		if(payload.country.equals("US")){
			return this.getWorkflowByName("workflow-2");
		}else{
			return this.getWorkflowByName("workflow-4");
		}
	}
}