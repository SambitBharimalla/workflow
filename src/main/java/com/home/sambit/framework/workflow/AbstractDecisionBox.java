package com.home.sambit.framework.workflow;

public abstract class AbstractDecisionBox implements DecisionBox {
	protected Workflow forkA;
	protected Workflow forkB;
	public void setForkA(Workflow forkA) {
		this.forkA = forkA;
	}
	public void setForkB(Workflow forkB) {
		this.forkB = forkB;
	}
}
