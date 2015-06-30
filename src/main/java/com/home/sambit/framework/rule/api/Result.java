package com.home.sambit.framework.rule.api;

public interface Result {
	public <R> R lookup(Key<R> key);
	public <R> R publish(Key<R> key, R result);
}
