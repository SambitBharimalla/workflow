package com.home.sambit.businesslogic.workflows;

import com.home.sambit.framework.workflow.AbstractMergeBox;

public class MergeA extends AbstractMergeBox {
	public void execute() {
		System.out.println(this.getClass().getCanonicalName() + " executed");
		this.forwardFlow.execute();
	}
}
