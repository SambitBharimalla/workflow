package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.AbstractTask;
import com.home.sambit.framework.workflow.TaskResult;

public class TaskEleven<P extends RequestPayload> extends AbstractTask<RequestPayload> {
	public void execute(RequestPayload payload, TaskResult taskResult) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		System.out.println("Looking up for KEY1 value : " + taskResult.lookupResult(TaskKey.KEY1));
	}
}
