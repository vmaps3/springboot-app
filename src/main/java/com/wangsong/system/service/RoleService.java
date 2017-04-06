package com.wangsong.system.service;

import java.util.List;

import com.wangsong.common.service.BaseService;
import com.wangsong.system.model.Role;
import com.wangsong.system.model.RoleResources;
import com.wangsong.system.model.User;

public interface RoleService extends BaseService<Role>{

    int insertRole(Role role);
    
    int updateRole(Role role);
    
    int deleteRole(String[] id);

	List<RoleResources> findRoleResourcesByRole(Role role);

	Role selectByPrimaryKey(String id);
}
