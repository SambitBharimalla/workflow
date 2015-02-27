package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.Task;
import com.home.sambit.framework.workflow.TaskResult;

public class TaskSeven implements Task {

	public TaskResult execute() {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		return null;
	}
}
