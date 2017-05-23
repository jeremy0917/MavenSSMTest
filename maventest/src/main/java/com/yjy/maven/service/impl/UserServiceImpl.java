package com.yjy.maven.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjy.maven.bean.User;
import com.yjy.maven.bean.UserBill;
import com.yjy.maven.bean.UserKey;
import com.yjy.maven.dao.UserBillMapper;
import com.yjy.maven.dao.UserMapper;
import com.yjy.maven.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Resource
	private UserMapper userDao;
	@Resource
	private UserBillMapper userBillDao;
	
	@Override
	public User getUserByUserId(long userId) {
		long partitionId = userId % 10000;
		UserKey userKey = new UserKey();
		userKey.setUserId(userId);
		userKey.setPartitionId((short)partitionId);
		return this.userDao.selectByPrimaryKey(userKey);
	}

	@Override
	public UserBill getUserBillByUserId(long userId) {
		UserBill userBill = new UserBill();
		userBill.setUserId(userId);
		return this.userBillDao.selectBillByUserId(userBill);
	}
	
}
