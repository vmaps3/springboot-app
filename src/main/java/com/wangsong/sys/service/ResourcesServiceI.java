package com.wangsong.sys.service;

import java.util.List;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.util.tree.JsonTreeData;

public interface ResourcesServiceI extends BaseServiceI<Resources>{

	int delete(String id);
	
	List<Resources> findResourceListByMap(String roleId);
	
	List<JsonTreeData> findResourceListByType();

	List<JsonTreeData> findMapListByType();

	
}
