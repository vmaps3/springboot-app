package com.wangsong.sys.dao;

import com.wangsong.sys.model.User;
import com.wangsong.sys.util.Page;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

	User findUserByLoginName(String username);
	
	int selectAllCount();
}