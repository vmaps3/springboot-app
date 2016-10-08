package com.wangsong.sys.dao;

import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import java.util.List;

public interface UserRoleMapper  extends BaseMapper<UserRole>{
    int deleteUserRoleByUser(User user);
    
    int deleteUserRoleByRole(Role role);

    List<UserRole> findUserRoleByUser(User user);

}