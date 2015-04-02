package com.home.sambit.framework.workflow;

import java.util.HashMap;
import java.util.Map;

import com.home.sambit.framework.workflow.api.Task;

public abstract class AbstractTask<PAYLOAD> implements Task<PAYLOAD> {
	protected String name;
	protected Map<ControlKey<?>, ControlKey.AccessType> resultKeyAccessPermissionMap = new HashMap<ControlKey<?>, ControlKey.AccessType>();

	public AbstractTask() {
		loadAccessPermission();
	}

	protected Map<ControlKey<?>, ControlKey.AccessType> allowedPermissionOnKeys() {
		return new HashMap<ControlKey<?>, ControlKey.AccessType>();
	}

	private void loadAccessPermission() {
		resultKeyAccessPermissionMap.putAll(allowedPermissionOnKeys());
	}
}