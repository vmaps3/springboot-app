package com.wangsong.sys.dao;

import java.util.List;
import java.util.Map;

import com.wangsong.sys.model.User;


public interface UserMapper extends BaseMapper<User>{

	User findUserByLoginName(String username);
	
	int selectAllCount(User user);

	List<User> selectAllByUser(User user);
}