package com.yjy.maventest;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.yjy.maven.bean.User;
import com.yjy.maven.service.IUserService;

public class testMybatisWithoutSpring {
	private static Logger logger = Logger.getLogger(testMybatisWithoutSpring.class);

	private IUserService userService = null;
	
	private ApplicationContext ac = null;  
	
	@Before
	public void before() throws BeansException, FileNotFoundException {
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		userService = (IUserService) ac.getBean("userService");
		/*BeanFactory f = new XmlBeanFactory((Resource) new FileInputStream("../spring-mybatis.xml"));
		userService = (IUserService) f.getBean("userService");*/
	}
	
	@Test
	public void test1() {
		User user = userService.getUserByUserId(1);
		logger.info(JSON.toJSONString(user));  
	}
}
