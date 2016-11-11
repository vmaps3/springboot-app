package com.wangsong.sys.service;

import java.util.List;

import com.wangsong.commons.service.BaseService;
import com.wangsong.commons.util.tree.JsonTreeData;
import com.wangsong.sys.model.Resources;

public interface ResourcesService extends BaseService<Resources>{

	int delete(String[] id);
	
	List<JsonTreeData> findResources();

	List<JsonTreeData> findResourcesEMUByResources();

	
}
