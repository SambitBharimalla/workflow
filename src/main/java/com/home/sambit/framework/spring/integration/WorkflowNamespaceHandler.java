package com.home.sambit.framework.spring.integration;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class WorkflowNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("Workflows", new WorkflowBeanDefinitionParser());
	}

}
