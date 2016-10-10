package com.wangsong.sys.dao;

import java.util.List;
import java.util.Map;

import com.wangsong.sys.model.User;
import com.wangsong.sys.util.Page;


public interface UserMapper extends BaseMapper<User>{

	User findUserByUser(User user);
	
	int findUserCountByUser(User user);

	List<User> findUserByPage(Page<User> page);
}