package com.yjy.maven.service;

import com.yjy.maven.bean.User;
import com.yjy.maven.bean.UserBill;

public interface IUserService {
	public User getUserByUserId(long userId);
	
	public UserBill getUserBillByUserId(long userId);
	
	public int insertUserBill(UserBill userBill);
}
