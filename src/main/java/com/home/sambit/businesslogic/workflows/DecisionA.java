package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.AbstractDecisionBox;
import com.home.sambit.framework.workflow.Workflow;

public class DecisionA<P extends RequestPayload> extends AbstractDecisionBox<P> {
	public Workflow<P> evaluate(P payload) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		if(payload.country.equals("US")){
			return this.branches.get(0);
		}else{
			return this.branches.get(1);
		}
	}
}