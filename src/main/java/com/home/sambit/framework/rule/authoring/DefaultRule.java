package com.home.sambit.framework.rule.authoring;

import java.util.List;

import com.home.sambit.framework.rule.api.Decision;
import com.home.sambit.framework.rule.api.Result;
import com.home.sambit.framework.rule.api.Rule;

public class DefaultRule<PAYLOAD> implements Rule<PAYLOAD>{
	private List<Condition> conditions;
	private List<Result> results;
	public Decision evaluate() {
		return null;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	
}