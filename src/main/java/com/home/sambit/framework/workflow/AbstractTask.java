package com.home.sambit.framework.workflow;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTask<PAYLOAD> implements Task<PAYLOAD> {
	protected String name;
	private Map<ControlKey, TaskKeyAccessTypes> resultKeyAccessPermissionMap = new HashMap<ControlKey, TaskKeyAccessTypes>();
	public AbstractTask() {
		loadAccessPermission();
	}
	protected Map<ControlKey, TaskKeyAccessTypes> allowedPermissionOnResultKey(){
		return new HashMap<ControlKey, TaskKeyAccessTypes>();
	}
	private void loadAccessPermission(){
		resultKeyAccessPermissionMap.putAll(allowedPermissionOnResultKey());
	}
}