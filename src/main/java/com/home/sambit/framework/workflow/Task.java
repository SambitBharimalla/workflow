package com.home.sambit.framework.workflow;

import java.util.List;


public interface Task<P> {
	public List<TaskResult> execute(P payload, List<TaskResult> ongoingTaskResults);
}