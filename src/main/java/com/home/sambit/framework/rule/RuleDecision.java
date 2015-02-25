package com.home.sambit.framework.rule;

public enum RuleDecision {
	TRUE("true"), FALSE("false");
	String name;
	private RuleDecision(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}