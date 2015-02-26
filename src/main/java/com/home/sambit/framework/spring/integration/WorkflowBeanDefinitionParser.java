package com.home.sambit.framework.spring.integration;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.home.sambit.framework.workflow.DefaultWorkflow;

public class WorkflowBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	protected Class<?> getBeanClass(Element element) {
		return DefaultWorkflow.class;
	}

	protected void doParse(Element element, ParserContext ctx, BeanDefinitionBuilder builder) {
		NodeList childrenOfWorkflow = element.getChildNodes();
		int noOfChildren = childrenOfWorkflow.getLength();
		for (int i = 0; i < noOfChildren; i++) {
			Node node = childrenOfWorkflow.item(i);
			String nodeName = node.getNodeName();
			if ("Sequence".equals(nodeName)) {
				NodeList tasks = node.getChildNodes();
				int totalTasks = tasks.getLength();
				for (int j = 0; j < totalTasks; j++) {
					Element task = (Element) tasks.item(j);
					String taskBeanReference = task.getAttribute("ref");
					BeanDefinition taskSpringBean = ctx.getRegistry().getBeanDefinition(taskBeanReference);
					System.out.println(taskSpringBean.getBeanClassName());
				}
			}
		}
	}
}