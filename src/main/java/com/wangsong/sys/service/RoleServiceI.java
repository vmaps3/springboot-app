package com.wangsong.sys.service;

import java.util.List;

import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.util.Page;

public interface RoleServiceI extends BaseServiceI<Role>{

    int insert(Role role, String[] resourcesId);
    
    int update(Role role, String[] resourcesId);
    
    int delete(String id);

	List<RoleResources> selectRoleResourcesAll(Role mrole);

	List<String> findRoleIdListByUserId(String id);

	Page selectAll(Page page);

}
