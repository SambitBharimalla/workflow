package com.home.sambit.framework.workflow;

import com.home.sambit.framework.workflow.api.MergeBox;
import com.home.sambit.framework.workflow.api.Workflow;

public class DefaultMergeBox<PAYLOAD> implements MergeBox<PAYLOAD> {
	protected Workflow<PAYLOAD> forwardFlow;
	public void setForwardFlow(Workflow<PAYLOAD> forwardFlow) {
		this.forwardFlow = forwardFlow;
	}
	public void execute(PAYLOAD payload, TaskResult taskResults) {
		System.out.println("Merging workflows");
		forwardFlow.execute(payload,taskResults); 
	}
}
