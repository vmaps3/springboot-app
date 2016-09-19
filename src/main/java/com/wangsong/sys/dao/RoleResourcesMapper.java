package com.wangsong.sys.dao;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import java.util.List;

public interface RoleResourcesMapper {
    int insert(RoleResources record);

    RoleResources selectByPrimaryKey(String id);

    List<RoleResources> selectAll();

    int updateByPrimaryKey(RoleResources record);

	List<RoleResources> selectByRole(Role mrole);

	int deleteByRole(Role role);

	int deleteByResources(Resources resources);
	
	
}