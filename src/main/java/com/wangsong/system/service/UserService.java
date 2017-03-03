package com.wangsong.system.service;

import java.util.List;

import com.wangsong.common.service.BaseService;
import com.wangsong.system.model.User;
import com.wangsong.system.model.UserRole;

public interface UserService extends BaseService<User>{
	
	User selectByPrimaryKey(String id);
	
    int insertUser(User muser);
    
    int updateUser(User muser);
    
    int deleteUser(String[] id);
    
    List<UserRole> findUserRoleByUser(User user);


	
}
