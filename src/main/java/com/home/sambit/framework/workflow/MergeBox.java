package com.home.sambit.framework.workflow;

public interface MergeBox<PAYLOAD> {
	public void execute(PAYLOAD payload, TaskResult taskResults);
}
