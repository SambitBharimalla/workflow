package com.home.sambit.framework.workflow.api;

import com.home.sambit.framework.workflow.TaskResult;


public interface MergeBox<PAYLOAD> {
	public void execute(PAYLOAD payload, TaskResult taskResults);
}
