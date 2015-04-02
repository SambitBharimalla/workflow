package com.home.sambit.framework.workflow;

public interface Task<PAYLOAD> {
	public void execute(PAYLOAD payload, TaskResult taskResults);
}