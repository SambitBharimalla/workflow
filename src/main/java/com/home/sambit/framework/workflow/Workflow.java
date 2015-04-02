package com.home.sambit.framework.workflow;

public interface Workflow<PAYLOAD> extends Worker<PAYLOAD>{
	public void execute(PAYLOAD payload, TaskResult ongoingResult);
}
