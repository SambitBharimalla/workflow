package com.home.sambit.framework.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.sambit.businesslogic.workflows.RequestPayload;
import com.home.sambit.framework.workflow.DefaultWorkflow;

public class App1 {
	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("spring/workflow-a.xml");
		String[] beans = context.getBeanDefinitionNames();
		DefaultWorkflow<RequestPayload> master = context.getBean("master", DefaultWorkflow.class);
		RequestPayload payload = new RequestPayload();
		payload.setCountry("US");
		master.execute(payload);
	}
}
