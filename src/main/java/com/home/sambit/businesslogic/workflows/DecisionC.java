package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.AbstractDecisionBox;
import com.home.sambit.framework.workflow.Workflow;

public class DecisionC extends AbstractDecisionBox {
	public Workflow evaluate() {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		double random = Math.random();
		if(random * 10 > 5){
			return this.branches.get(0);
		}else{
			return this.branches.get(1);
		}
	}
}