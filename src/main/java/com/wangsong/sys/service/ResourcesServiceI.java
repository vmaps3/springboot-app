package com.wangsong.sys.service;

import java.util.List;
import java.util.Map;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;

public interface ResourcesServiceI {

	List<Resources> selectAll();
	
	Resources selectByPrimaryKey(String id);
	
    int insert(Resources resources);
    
    int update(Resources resources);
    
    int delete(String id);

    List<Map<String, Object>> selectAll(Resources mresources);

	List<String> findResourceListByRoleId(String roleId);
	
	List<Map<String, Object>> findResourceListByType(String pid);
	
}
