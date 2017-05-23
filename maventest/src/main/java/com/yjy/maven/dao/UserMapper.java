package com.yjy.maven.dao;

import com.yjy.maven.bean.User;
import com.yjy.maven.bean.UserKey;

public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}