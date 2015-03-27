package com.home.sambit.businesslogic.workflows;

import java.util.List;

import com.home.sambit.framework.workflow.AbstractTask;
import com.home.sambit.framework.workflow.Task;
import com.home.sambit.framework.workflow.TaskResult;

@SuppressWarnings("hiding")
public class TaskSix<RequestPayload> extends AbstractTask<RequestPayload> {
	public List<TaskResult> execute(RequestPayload payload, List<TaskResult> ongoingResult) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		return null;
	}
}
