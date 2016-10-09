package com.wangsong.sys.service;

import java.util.List;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.util.tree.JsonTreeData;

public interface ResourcesService extends BaseService<Resources>{

	int delete(String[] id);
	
	List<Resources> findResourcesShiroByResources(Resources resources);
	
	List<JsonTreeData> findResources();

	List<JsonTreeData> findResourcesEMUByResources();

	
}
