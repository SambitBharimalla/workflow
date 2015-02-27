package com.home.sambit.framework.workflow;

import java.util.List;

public abstract class AbstractDecisionBox implements DecisionBox {
	protected Workflow forkA;
	protected Workflow forkB;
	protected List<Workflow> branches;
	public void setForkA(Workflow forkA) {
		this.forkA = forkA;
	}
	public void setForkB(Workflow forkB) {
		this.forkB = forkB;
	}
	public void setBranches(List<Workflow> branches) {
		this.branches = branches;
	}
}
