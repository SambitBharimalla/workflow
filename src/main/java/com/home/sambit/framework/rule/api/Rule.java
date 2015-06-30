package com.home.sambit.framework.rule.api;

public interface Rule<PAYLOAD> {
	public Decision evaluate();
}