package com.wangsong.sys.service;

import java.util.List;

import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import com.wangsong.sys.util.Page;

public interface UserService extends BaseService<User>{

	Page<User> findUserByPage(Page<User> page);
	
	User selectByPrimaryKey(String id);
	
    int insert(User muser, String[] roleId);
    
    int update(User muser, String[] roleId);
    
    int delete(String[] id);
    
    List<UserRole> findUserRoleByUser(User user);

	User findUserByUser(User user);
}
