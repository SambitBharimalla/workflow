package com.home.sambit.framework.workflow;

import java.util.List;

public abstract class AbstractDecisionBox<P> implements DecisionBox<P> {
	protected Workflow<P> forkA;
	protected Workflow<P> forkB;
	protected List<Workflow<P>> branches;

	public void setForkA(Workflow<P> forkA) {
		this.forkA = forkA;
	}

	public void setForkB(Workflow<P> forkB) {
		this.forkB = forkB;
	}

	public void setBranches(List<Workflow<P>> branches) {
		this.branches = branches;
	}
}
