package com.home.sambit.businesslogic.workflows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.home.sambit.framework.workflow.AbstractTask;
import com.home.sambit.framework.workflow.ControlKey;
import com.home.sambit.framework.workflow.TaskKeyAccessTypes;
import com.home.sambit.framework.workflow.TaskResult;

@SuppressWarnings("hiding")
public class TaskOne<RequestPayload> extends AbstractTask<RequestPayload> {
	public List<TaskResult> execute(RequestPayload payload, List<TaskResult> ongoingResult) {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		return null;
	}
	@Override
	protected Map<ControlKey, TaskKeyAccessTypes> allowedPermissionOnResultKey() {
		HashMap<ControlKey, TaskKeyAccessTypes> permissionMap = new HashMap<ControlKey, TaskKeyAccessTypes>();
		permissionMap.put(TaskKeyTypes.TASK1_RESULT, TaskKeyAccessTypes.READ);
		return permissionMap;
	}
}