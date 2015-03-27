package com.home.sambit.businesslogic.workflows;

import java.util.List;

import com.home.sambit.framework.workflow.AbstractTask;
import com.home.sambit.framework.workflow.TaskResult;

@SuppressWarnings("hiding")
public class TaskEleven<RequestPayload> extends AbstractTask<RequestPayload> {
	public List<TaskResult> execute(RequestPayload payload, List<TaskResult> ongoingResult) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		return null;
	}
}
