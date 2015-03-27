package com.home.sambit.framework.workflow;

public interface DecisionBox<PAYLOAD> {
	public Workflow<PAYLOAD> evaluate(PAYLOAD payload);
}
