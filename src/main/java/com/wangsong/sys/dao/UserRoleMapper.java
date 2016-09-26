package com.wangsong.sys.dao;

import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import java.util.List;

public interface UserRoleMapper  extends BaseMapper<UserRole>{
    int deleteByUser(User user);
    
    int deleteByRole(Role role);

    List<UserRole> selectByUser(User user);

	List<String> findRoleIdListByUserId(String id);

}