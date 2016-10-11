package com.wangsong.sys.dao;

import com.wangsong.sys.model.User;

public interface UserMapper extends BaseMapper<User>{

	User findUserByUser(User user);
}