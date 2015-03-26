package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.AbstractTask;
import com.home.sambit.framework.workflow.TaskResult;

@SuppressWarnings("hiding")
public class TaskEight<RequestPayload> extends AbstractTask<RequestPayload> {
	public TaskResult execute(RequestPayload payload) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		return null;
	}
}
