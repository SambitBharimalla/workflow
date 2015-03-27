package com.home.sambit.framework.workflow;

public interface Workflow<P> {
	public void execute(P payload);
}
