package com.yjy.maventest.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ASleep a = (ASleep)ac.getBean("aSleep");
		BSleep b = (BSleep)ac.getBean("bSleep");
		a.sleep();
		System.out.println();
		b.sleep();
	}
}
