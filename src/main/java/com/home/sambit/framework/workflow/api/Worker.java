package com.home.sambit.framework.workflow.api;

public interface Worker<PAYLOAD> {
	public void execute(PAYLOAD payload);
}
