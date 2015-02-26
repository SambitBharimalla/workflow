package com.home.sambit.framework.spring.integration;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
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
		return true;
	}
	protected void doParse(Element element, ParserContext ctx, BeanDefinitionBuilder builder) {
		NodeList allWorkflows = element.getElementsByTagName("wf:Workflow");
		
		for (int i = 0; i < allWorkflows.getLength(); i++) {
			Element workflow = (Element)allWorkflows.item(i);
			System.out.println(workflow.getLocalName() + " - " + workflow.getNodeName() + " - " + workflow.getNodeType() + " - " + workflow.getNodeValue());
			if(workflow.hasAttribute("id") || !workflow.hasAttribute("ref")){
				Element sequence = (Element)workflow.getElementsByTagName("wf:Sequence").item(0);
				NodeList tasks = sequence.getElementsByTagName("wf:Task");
				for (int j = 0; j < tasks.getLength(); j++) {
					Element task = (Element) tasks.item(j);
					String taskBeanReference = task.getAttribute("ref");
					BeanDefinition taskSpringBean = ctx.getRegistry().getBeanDefinition(taskBeanReference);
					System.out.println(taskSpringBean.getBeanClassName() + " - " + taskSpringBean.getScope());
				}
			}
		}
	}
}