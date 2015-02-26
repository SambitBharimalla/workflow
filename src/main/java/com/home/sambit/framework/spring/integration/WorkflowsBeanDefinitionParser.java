package com.home.sambit.framework.spring.integration;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.home.sambit.framework.workflow.DefaultWorkflow;

public class WorkflowsBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected boolean shouldGenerateId() {
		return true;
	}
	protected Class<?> getBeanClass(Element element) {
		return DefaultWorkflow.class;
	}
	protected void doParse(Element element, ParserContext ctx, BeanDefinitionBuilder builder) {
		System.out.println("entered");
	}

}
