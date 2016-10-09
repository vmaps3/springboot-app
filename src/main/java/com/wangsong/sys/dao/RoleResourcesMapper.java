package com.wangsong.sys.dao;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import java.util.List;

public interface RoleResourcesMapper extends BaseMapper<RoleResources>{

	List<RoleResources> findRoleByRole(Role mrole);

	int deleteRoleResourcesByRole(Role[] r);

	int deleteRoleResourcesByResources(Resources[] r);
	
	
}