package com.home.sambit.businesslogic.workflows;

import java.util.HashMap;
import java.util.Map;

import com.home.sambit.framework.workflow.AbstractTask;
import com.home.sambit.framework.workflow.TaskResult;
import com.home.sambit.framework.workflow.api.ControlKey;

public class TaskOne<P extends RequestPayload> extends AbstractTask<RequestPayload> {
	public void execute(RequestPayload payload, TaskResult taskResult) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		taskResult.publishResult(TaskKey.KEY1, "Hello");
		taskResult.publishResult(TaskKey.KEY3, 12L);
	}
	protected Map<ControlKey<?>, ControlKey.AccessType> allowedPermissionOnKeys() {
		HashMap<ControlKey<?>, ControlKey.AccessType> permissionMap = new HashMap<ControlKey<?>, ControlKey.AccessType>();
		permissionMap.put(TaskKey.KEY1, ControlKey.AccessType.WRITE);
		permissionMap.put(TaskKey.KEY2, ControlKey.AccessType.WRITE);
		return permissionMap;
	}
}