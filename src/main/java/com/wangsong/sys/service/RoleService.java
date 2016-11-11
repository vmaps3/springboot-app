package com.wangsong.sys.service;

import java.util.List;

import com.wangsong.commons.service.BaseService;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;

public interface RoleService extends BaseService<Role>{

    int insert(Role role, String[] resourcesId);
    
    int update(Role role, String[] resourcesId);
    
    int delete(String[] id);

	List<RoleResources> findRoleResourcesByRole(Role role);

}
