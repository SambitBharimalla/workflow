package com.home.sambit.framework.spring.integration;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.home.sambit.framework.workflow.DefaultWorkflow;

public class WorkflowBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	protected Class<?> getBeanClass(Element element) {
		return DefaultWorkflow.class;
	}

	@Override
	protected boolean shouldGenerateId() {
		return false;
	}

	@Override
	protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws BeanDefinitionStoreException {
		return element.getAttribute("id");
	}

	protected void doParse(Element element, ParserContext ctx, BeanDefinitionBuilder builder) {
		NodeList workflowChild = element.getChildNodes();
		ManagedList<Object> taskList = new ManagedList<Object>();
		GenericBeanDefinition decisionBoxSpringBean = null;

		for (int i = 0; i < workflowChild.getLength(); i++) {
			if ("Sequence".equals(workflowChild.item(i).getLocalName())) {
				NodeList tasks = workflowChild.item(i).getChildNodes();
				for (int j = 0; j < tasks.getLength(); j++) {
					if ("Task".equals(tasks.item(j).getLocalName())) {
						Element task = (Element) tasks.item(j);
						String taskBeanReference = task.getAttribute("ref");
						BeanDefinition taskSpringBean = ctx.getRegistry().getBeanDefinition(taskBeanReference);
						taskList.add(taskSpringBean);
					}
				}
			}
			if ("OneOf".equals(workflowChild.item(i).getLocalName())) {
				Element oneOf = (Element) workflowChild.item(i);
				String springRefBasedOn = oneOf.getAttribute("basedOn");
				decisionBoxSpringBean = (GenericBeanDefinition) ctx.getRegistry().getBeanDefinition(springRefBasedOn);
				MutablePropertyValues decisionBoxProperties = decisionBoxSpringBean.getPropertyValues();
				ManagedList<Object> branches = new ManagedList<Object>();
				NodeList childOfOneOf = oneOf.getElementsByTagName("wf:Workflow");
				for (int k = 0; k < childOfOneOf.getLength(); k++) {
					if ("Workflow".equals(childOfOneOf.item(k).getLocalName())) {
						Element branchedWorkflows = (Element) childOfOneOf.item(k);
						String refWorkflow = branchedWorkflows.getAttribute("ref");
						if (!ctx.getRegistry().containsBeanDefinition(refWorkflow)) {
							builder.addDependsOn(refWorkflow);
						}
						branches.add(new RuntimeBeanReference(refWorkflow));
						
//						if (propertyValue.contains("forkA")) {
//							propertyValue.add("forkB", new RuntimeBeanReference(refWorkflow));
//						} else {
//							propertyValue.add("forkA", new RuntimeBeanReference(refWorkflow));
//						}
						
					}
					decisionBoxProperties.add("branches", branches);
					decisionBoxSpringBean.setPropertyValues(decisionBoxProperties);
				}
			}
			builder.addPropertyValue("tasks", taskList);
			builder.addPropertyValue("decision", decisionBoxSpringBean);
		}
	}
}