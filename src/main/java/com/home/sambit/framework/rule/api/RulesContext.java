package com.home.sambit.framework.rule.api;

import java.util.HashMap;

public class RulesContext {
	private HashMap<RuleParam, String> input = new HashMap<RulesContext.RuleParam, String>();
	private HashMap<RuleParam, String> output = new HashMap<RulesContext.RuleParam, String>();
	public enum RuleParam{
		MAXLOANLIMITBASEDONLOANHIST, MAXALLOWEDCURRENTLOAN, MAXLOANLIMITBASEDONCDTTHIST;
	}
}