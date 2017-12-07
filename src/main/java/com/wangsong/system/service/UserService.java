package com.wangsong.system.service;

import com.wangsong.common.model.Result;
import com.wangsong.system.model.User;
import com.wangsong.system.model.UserPage;
import com.wangsong.system.vo.UserVO;

public interface UserService {
	
	User selectByPrimaryKey();
	
	Result insertUser(User muser, String[] roleId);
    
    Result updateUser(User muser, String[] roleId);
    
    Result deleteUser(String[] id);
    
    Result updatePassword(User u);

	Object findTByPage(UserPage user);

	Result index();

	Result logoutJSON();

	Result unauth();

	Result loginPost(String username, String password);

	UserVO selectByPrimaryKey(String id);

	User findTByT(User user);


	
}
