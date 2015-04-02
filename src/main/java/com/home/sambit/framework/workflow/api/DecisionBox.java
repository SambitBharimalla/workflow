package com.home.sambit.framework.workflow.api;

import com.home.sambit.framework.workflow.TaskResult;


public interface DecisionBox<PAYLOAD> {
	public Workflow<PAYLOAD> evaluate(PAYLOAD payload, TaskResult taskResult);
}
