package com.home.sambit.framework.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("spring/workflow-ns.4.xml");
		System.out.println(context.getBeanDefinitionCount());
	}
}
