package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.AbstractTask;
import com.home.sambit.framework.workflow.TaskResult;

public class TaskEight<P extends RequestPayload> extends AbstractTask<RequestPayload> {
	public void execute(RequestPayload payload, TaskResult taskResult) {
		TaskResult result = new TaskResult();
		result.publishResult(TaskKey.KEY1, "Hi");
		result.publishResult(TaskKey.KEY2, 1);
	}
}
