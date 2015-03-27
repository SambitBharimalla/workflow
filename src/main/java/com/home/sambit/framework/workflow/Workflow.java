package com.home.sambit.framework.workflow;

public interface Workflow<PAYLOAD> {
	public void execute(PAYLOAD payload);
}
