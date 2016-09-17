package com.wangsong.sys.service;

import java.util.List;
import java.util.Map;

import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;

public interface UserServiceI {

	List<User> selectAll();
	
	User selectByPrimaryKey(String id);
	
    int insert(User muser, String[] roleId);
    
    int update(User muser, String[] roleId);
    
    int delete(String id);
    
    List<Map<String, Object>> selectUserRoleAll(User user);
}
