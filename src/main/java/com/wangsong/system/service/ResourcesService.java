package com.wangsong.system.service;

import java.util.List;

import com.wangsong.common.model.JsonTreeData;
import com.wangsong.common.service.BaseService;
import com.wangsong.system.model.Resources;

public interface ResourcesService extends BaseService<Resources>{

	int deleteResources(String[] id);
	
	int insertResources(Resources resources);
	
	List<JsonTreeData> findResources();

	List<JsonTreeData> findResourcesEMUByResources();

	int updateResources(Resources resources);
	
}
