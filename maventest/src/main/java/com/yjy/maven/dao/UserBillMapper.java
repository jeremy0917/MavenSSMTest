package com.yjy.maven.dao;

import com.yjy.maven.bean.UserBill;

public interface UserBillMapper {
    int insert(UserBill record);

    int insertSelective(UserBill record);
    
    UserBill selectBillByUserId(UserBill record);
}