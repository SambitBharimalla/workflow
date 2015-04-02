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
		GenericBeanDefinition mergeBoxSpringBean = null;

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
					}
					decisionBoxProperties.add("branches", branches);
					decisionBoxSpringBean.setPropertyValues(decisionBoxProperties);
				}
			}
			if ("MergeTo".equals(workflowChild.item(i).getLocalName())) {
				Element mergeTo = (Element) workflowChild.item(i);
				String springRefMergeTo = mergeTo.getAttribute("ref");
				mergeBoxSpringBean = (GenericBeanDefinition) ctx.getRegistry().getBeanDefinition(springRefMergeTo);
				MutablePropertyValues mergeBoxProperties = mergeBoxSpringBean.getPropertyValues();
				NodeList childOfMergeTo = mergeTo.getElementsByTagName("wf:Workflow");
				for (int k = 0; k < childOfMergeTo.getLength(); k++) {
					if ("Workflow".equals(childOfMergeTo.item(k).getLocalName())) {
						Element forwardWorkflow = (Element) childOfMergeTo.item(k);
						String refWorkflow = forwardWorkflow.getAttribute("ref");
						if (!ctx.getRegistry().containsBeanDefinition(refWorkflow)) {
							builder.addDependsOn(refWorkflow);
						}
						mergeBoxProperties.add("forwardFlow", new RuntimeBeanReference(refWorkflow));
					}

				}
				mergeBoxSpringBean.setPropertyValues(mergeBoxProperties);
			}
			builder.addPropertyValue("tasks", taskList);
			builder.addPropertyValue("decisionBox", decisionBoxSpringBean);
			builder.addPropertyValue("mergeBox", mergeBoxSpringBean);
			builder.addPropertyValue("name", element.getAttribute("name"));
		}
	}
}