package com.home.sambit.framework.workflow;


public class TaskResult {
	private TaskKey variable;
	private Object data;
	private Class<Task> publishedBy;
	private long lastupdatedTimeStamp;

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Class<Task> getPublishedBy() {
		return publishedBy;
	}
	public void setPublishedBy(Class<Task> publishedBy) {
		this.publishedBy = publishedBy;
	}
	public long getLastupdatedTimeStamp() {
		return lastupdatedTimeStamp;
	}
	public void setLastupdatedTimeStamp(long lastupdatedTimeStamp) {
		this.lastupdatedTimeStamp = lastupdatedTimeStamp;
	}
	public TaskKey getVariable() {
		return variable;
	}
	public void setVariable(TaskKey variable) {
		this.variable = variable;
	}
}
