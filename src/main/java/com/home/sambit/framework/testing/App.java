package com.home.sambit.framework.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.sambit.framework.workflow.DefaultWorkflow;

public class App {
	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("spring/workflow-ns.4.xml");
		String[] beans = context.getBeanDefinitionNames();
		DefaultWorkflow childA = context.getBean("master-flow", DefaultWorkflow.class);
		childA.executeFlow();
	}
}
