package com.home.sambit.framework.workflow;


public interface Task<T> {
	public TaskResult execute(T payload);
}