package com.home.sambit.framework.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

public abstract class AbstractTask<T> implements Task<T> {
	private List<TaskResult> taskResults;
	protected String name;
	private Map<TaskKey, TaskKeyAccessTypes> resultKeyAccessPermissionMap = new HashMap<TaskKey, TaskKeyAccessTypes>();
	public AbstractTask() {
		loadAccessPermission();
	}
	@SuppressWarnings("unchecked")
	protected void publishResultTo(TaskKey key, Object data){
		if(!resultKeyAccessPermissionMap.containsKey(key) ||
				!resultKeyAccessPermissionMap.get(key).equals(TaskKeyAccessTypes.WRITE)){
			throw new RuntimeException("Task " + this.name + " dont have permission to publish to " + key);
		}
		TaskResult taskResult = new TaskResult();
		taskResult.setData(data);
		taskResult.setLastupdatedTimeStamp(DateTime.now().getMillis());
		taskResult.setPublishedBy((Class<Task>)this.getClass());
		taskResult.setVariable(key);
		taskResults.add(taskResult);
	}
	protected TaskResult lookupResultByKey(TaskKey key){
		if(!resultKeyAccessPermissionMap.containsKey(key) ||
				!resultKeyAccessPermissionMap.get(key).equals(TaskKeyAccessTypes.READ) ||
				!resultKeyAccessPermissionMap.get(key).equals(TaskKeyAccessTypes.WRITE)){
			throw new RuntimeException("Task " + this.name + " dont have permission to read " + key);
		}
		for (TaskResult taskResult : taskResults) {
			if(taskResult.getVariable().equals(key)){
				return taskResult;
			}
		}
		return null;
	}
	protected Map<TaskKey, TaskKeyAccessTypes> allowedPermissionOnResultKey(){
		return new HashMap<TaskKey, TaskKeyAccessTypes>();
	}
	private void loadAccessPermission(){
		resultKeyAccessPermissionMap.putAll(allowedPermissionOnResultKey());
	}
}