package com.home.sambit.framework.workflow;

import java.util.List;

public abstract class AbstractDecisionBox<PAYLOAD> implements DecisionBox<PAYLOAD> {
	protected List<Workflow<PAYLOAD>> branches;

	public void setBranches(List<Workflow<PAYLOAD>> branches) {
		this.branches = branches;
	}
}
