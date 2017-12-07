package com.wangsong.system.service;

import com.wangsong.common.model.Result;
import com.wangsong.system.model.User;
import com.wangsong.system.model.UserAddModel;
import com.wangsong.system.model.UserPage;
import com.wangsong.system.vo.UserVO;

public interface UserService {
	
	User selectByPrimaryKey();
	
	Result insertUser(UserAddModel muser);
    
    Result updateUser(UserAddModel muser);
    
    Result deleteUser(String[] id);
    
    Result updatePassword(UserAddModel u);

	Object findTByPage(UserPage user);

	Result index();

	Result logoutJSON();

	Result unauth();

	Result loginPost(String username, String password);

	UserVO selectByPrimaryKey(String id);

	User findTByT(User user);


	
}
