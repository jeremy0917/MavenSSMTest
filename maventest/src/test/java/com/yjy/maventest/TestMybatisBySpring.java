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
	
	@Test
	public void test3() {
		DatabaseContextHolder.setCustomerType(DatabaseContextHolder.DATA_SOURCE_ACTPAR1);
		UserBill userBill = new UserBill();
		userBill.setBillId(1L);
		userBill.setAcctId(1L);
		userBill.setUserId(1L);
		userBill.setPartitionId((short)1);
		userBill.setCycleId(1);
		userBill.setIntegrateItemCode(1);
		userBill.setFee(1L);
		userBill.setBalance(1L);
		userBill.setPrintFee(1L);
		userBill.setbDiscnt(1L);
		userBill.setaDiscnt(1L);
		userBill.setAdjustBefore(1L);
		userBill.setAdjustAfter(1L);
		userBill.setLateFee(1L);
		userBill.setLateBalance(1L);
		userBill.setCanpayTag("1");
		userBill.setPayTag("1");
		
		
		int reslut = userService.insertUserBill(userBill);
		//UserBill userBill = userService.getUserBillByUserId(Long.parseLong("1113111498769571"));
		logger.info(reslut);
		logger.info(JSON.toJSONString(userBill));
	}
}
