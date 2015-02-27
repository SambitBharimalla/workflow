package com.home.sambit.framework.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.sambit.framework.workflow.DefaultWorkflow;

public class App1 {
	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("spring/workflow-a.xml");
		String[] beans = context.getBeanDefinitionNames();
		DefaultWorkflow master = context.getBean("master", DefaultWorkflow.class);
		master.execute();
	}
}
