package com.wangsong.sys.dao;

import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import java.util.List;

public interface UserRoleMapper {
    int deleteByUser(User user);
    
    int deleteByRole(Role role);

    int insert(UserRole record);

    List<UserRole> selectByUser(User user);

   
}