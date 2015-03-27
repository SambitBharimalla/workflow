package com.home.sambit.framework.workflow;

public abstract class AbstractMergeBox implements MergeBox {
	protected Workflow<?> forwardFlow;
	public void setForwardFlow(Workflow<?> forwardFlow) {
		this.forwardFlow = forwardFlow;
	}
}
