package com.wangsong.sys.service;

import java.util.List;

import com.wangsong.commons.service.BaseService;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;

public interface UserService extends BaseService<User>{
	
	User selectByPrimaryKey(String id);
	
    int insert(User muser, String[] roleId);
    
    int update(User muser, String[] roleId);
    
    int delete(String[] id);
    
    List<UserRole> findUserRoleByUser(User user);


	
}
