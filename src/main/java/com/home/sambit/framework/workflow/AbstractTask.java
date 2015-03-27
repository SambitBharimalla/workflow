package com.home.sambit.framework.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

public abstract class AbstractTask<T> implements Task<T> {
	private List<TaskResult> taskResults;
	protected String name;
	private Map<ControlKey, TaskKeyAccessTypes> resultKeyAccessPermissionMap = new HashMap<ControlKey, TaskKeyAccessTypes>();
	public AbstractTask() {
		loadAccessPermission();
	}
	@SuppressWarnings("unchecked")
	protected void publishResultTo(ControlKey key, Object data){
		if(!resultKeyAccessPermissionMap.containsKey(key) ||
				!resultKeyAccessPermissionMap.get(key).equals(TaskKeyAccessTypes.WRITE)){
			throw new RuntimeException("Task " + this.name + " dont have permission to publish to " + key);
		}
		TaskResult taskResult = new TaskResult();
		taskResult.setData(data);
		taskResult.setLastupdatedTimeStamp(DateTime.now().getMillis());
		taskResult.setPublishedBy((Class<Task>)this.getClass());
		taskResult.setKey(key);
		taskResults.add(taskResult);
	}
	protected TaskResult lookupResultByKey(ControlKey key){
		if(!resultKeyAccessPermissionMap.containsKey(key) ||
				!resultKeyAccessPermissionMap.get(key).equals(TaskKeyAccessTypes.READ) ||
				!resultKeyAccessPermissionMap.get(key).equals(TaskKeyAccessTypes.WRITE)){
			throw new RuntimeException("Task " + this.name + " dont have permission to read " + key);
		}
		for (TaskResult taskResult : taskResults) {
			if(taskResult.getKey().equals(key)){
				return taskResult;
			}
		}
		return null;
	}
	protected Map<ControlKey, TaskKeyAccessTypes> allowedPermissionOnResultKey(){
		return new HashMap<ControlKey, TaskKeyAccessTypes>();
	}
	private void loadAccessPermission(){
		resultKeyAccessPermissionMap.putAll(allowedPermissionOnResultKey());
	}
}