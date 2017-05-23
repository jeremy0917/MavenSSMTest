package com.yjy.maventest;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.yjy.maven.bean.UserBill;
import com.yjy.maven.datasource.DatabaseContextHolder;
import com.yjy.maven.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  

public class TestMybatisBySpring {
	private static Logger logger = Logger.getLogger(TestMybatisBySpring.class);
	@Resource
	private IUserService userService = null;
	
	@Test
	public void test1() {
		/*DatabaseContextHolder.setCustomerType(DatabaseContextHolder.DATA_SOURCE_CRMTEST);
		User user = userService.getUserByUserId(1);
		logger.info(JSON.toJSONString(user));*/
		DatabaseContextHolder.setCustomerType(DatabaseContextHolder.DATA_SOURCE_ACTPAR1);
		UserBill userBill = userService.getUserBillByUserId(Long.parseLong("2910063021038582"));
		logger.info(Long.parseLong("2910063021038582"));
		logger.info(JSON.toJSONString(userBill));
	}
	
	@Test
	public void test2() {
		DatabaseContextHolder.setCustomerType(DatabaseContextHolder.DATA_SOURCE_ACTPAR1);
		UserBill userBill = userService.getUserBillByUserId(Long.parseLong("1113111498769571"));
		logger.info(Long.parseLong("1113111498769571"));
		logger.info(JSON.toJSONString(userBill));
	}
}
