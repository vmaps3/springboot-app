package com.wangsong.sys.service;

import java.util.List;
import java.util.Map;

import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;

public interface RoleServiceI {

	List<Role> selectAll();
	
	Role selectByPrimaryKey(String id);
	
    int insert(Role role, String[] resourcesId);
    
    int update(Role role);
    
    int delete(String id);

	List<Map<String, Object>> selectRoleResourcesAll(Role mrole);
}
