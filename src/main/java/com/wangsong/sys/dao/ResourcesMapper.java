package com.wangsong.sys.dao;

import com.wangsong.sys.model.Resources;

import java.util.List;

public interface ResourcesMapper extends BaseMapper<Resources>{

	List<Resources> findResourcesByResources(Resources resources);
}