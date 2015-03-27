package com.home.sambit.framework.workflow;


public class TaskResult {
	private ControlKey key;
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
	public ControlKey getKey() {
		return key;
	}
	public void setKey(ControlKey key) {
		this.key = key;
	}
}
