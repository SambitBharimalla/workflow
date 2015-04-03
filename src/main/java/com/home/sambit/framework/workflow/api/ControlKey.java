package com.home.sambit.framework.workflow.api;

public interface ControlKey<VALUETYPE> {
	public enum AccessType {
		WRITE("write.permission");
		private String name;
		private AccessType(String name) {
			this.name=name;
		}
		public String getName() {
			return name;
		}
	}
}
