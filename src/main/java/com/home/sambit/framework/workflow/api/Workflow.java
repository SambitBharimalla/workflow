package com.home.sambit.framework.workflow.api;

import com.home.sambit.framework.workflow.TaskResult;


public interface Workflow<PAYLOAD> extends Worker<PAYLOAD>{
	public void execute(PAYLOAD payload, TaskResult ongoingResult);
}
