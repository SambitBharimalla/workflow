package com.home.sambit.framework.workflow;

public enum TaskKeyAccessTypes {
	WRITE("write.permission"), READ("read.permission");
	private String name;
	private TaskKeyAccessTypes(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
}