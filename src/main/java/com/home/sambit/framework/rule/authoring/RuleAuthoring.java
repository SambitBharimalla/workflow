package com.home.sambit.framework.rule.authoring;

import com.home.sambit.framework.rule.authoring.Condition.Boolean;

public class RuleAuthoring {
	public void author(){
		Define.ruleAs("MAXLOANLIMITBASEDONLOANHIST").when(Boolean.TRUE).AND.when(Boolean.FALSE).thenReturn(new RuleResult());;
	}
}