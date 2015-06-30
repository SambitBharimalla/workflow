package com.home.sambit.framework.rule.authoring;

import com.home.sambit.framework.rule.api.Result;
import com.home.sambit.framework.rule.api.Rule;

public class Define {
	private static final Define INSTANCE = new Define();
	public static final Define AND = INSTANCE;
	public static Define ruleAs(String name){
		return null;
	}
	public Define when(Condition condition){
		return null;
	}
	public Rule thenReturn(Result... results){
		return null;
	}
}
