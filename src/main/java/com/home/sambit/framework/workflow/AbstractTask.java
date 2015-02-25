package com.home.sambit.framework.workflow;

public abstract class AbstractTask implements Task {
	private String name;
	public abstract TaskResult execute(); 
}