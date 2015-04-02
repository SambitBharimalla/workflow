package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.DefaultMergeBox;

public class MergeA extends DefaultMergeBox {
	public void execute() {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		this.forwardFlow.execute(null); // TODO: Replace Null
	}
}
