package com.home.sambit.businesslogic.workflows;

import java.util.HashMap;
import java.util.Map;

import com.home.sambit.framework.workflow.AbstractTask;
import com.home.sambit.framework.workflow.TaskKey;
import com.home.sambit.framework.workflow.TaskKeyAccessTypes;
import com.home.sambit.framework.workflow.TaskResult;

public class TaskOne<RequestPayload> extends AbstractTask<RequestPayload> {
	public TaskResult execute(RequestPayload payload) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		return null;
	}
	@Override
	protected Map<TaskKey, TaskKeyAccessTypes> allowedPermissionOnResultKey() {
		HashMap<TaskKey, TaskKeyAccessTypes> permissionMap = new HashMap<TaskKey, TaskKeyAccessTypes>();
		permissionMap.put(TaskKeyTypes.TASK1_RESULT, TaskKeyAccessTypes.READ);
		return permissionMap;
	}
}