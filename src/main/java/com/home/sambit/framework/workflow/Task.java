package com.home.sambit.framework.workflow;

import java.util.List;


public interface Task<PAYLOAD> {
	public List<TaskResult> execute(PAYLOAD payload, List<TaskResult> ongoingTaskResults);
}