package com.home.sambit.framework.workflow;

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
