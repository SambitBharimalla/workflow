package com.home.sambit.framework.workflow;

import java.util.HashMap;
import java.util.Map;

import com.home.sambit.framework.workflow.api.ControlKey;

public class TaskResult {
	protected Map<ControlKey<?>, Object> map = new HashMap<ControlKey<?>, Object>();
	protected Map<ControlKey<?>, Object> tempStorage = new HashMap<ControlKey<?>, Object>();
	public <VALUETYPE> void publishResult(ControlKey<VALUETYPE> key, VALUETYPE value){
		if(key==null) {
			throw new NullPointerException("Key is Null");
		}
		tempStorage.put(key, value);
	}
	protected void finalPublish(){
		map.putAll(this.tempStorage);
		// Finally clean up temp storage
		this.tempStorage=new HashMap<ControlKey<?>, Object>();
	}
	@SuppressWarnings("unchecked")
	public <VALUETYPE> VALUETYPE lookupResult(ControlKey<VALUETYPE> key){
		return (VALUETYPE) map.get(key);
	}
	public <VALUETYPE> boolean hasResult(ControlKey<VALUETYPE> key){
		return map.containsKey(key);
	}
}