package com.home.sambit.framework.workflow;

public interface Worker<PAYLOAD> {
	public void execute(PAYLOAD payload);
}
