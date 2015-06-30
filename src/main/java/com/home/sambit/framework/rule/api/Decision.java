package com.home.sambit.framework.rule.api;

public class Decision {
	private Action ruleAction;
	private Result ruleResult;
	public Action getRuleAction() {
		return ruleAction;
	}
	public void setRuleAction(Action ruleAction) {
		this.ruleAction = ruleAction;
	}
	public Result getRuleResult() {
		return ruleResult;
	}
	public void setRuleResult(Result ruleResult) {
		this.ruleResult = ruleResult;
	}
}