package com.wangsong.sys.service;

import java.util.List;
import java.util.Map;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.util.JsonTreeData;
import com.wangsong.sys.util.Page;

public interface ResourcesServiceI extends BaseServiceI<Resources>{

	
	List<String> findResourceListByRoleId(String roleId);
	
	List<JsonTreeData> findResourceListByType();

	List<JsonTreeData> findMapListByType();

	
}
