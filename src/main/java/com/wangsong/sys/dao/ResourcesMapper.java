package com.wangsong.sys.dao;

import com.wangsong.sys.model.Resources;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper extends BaseMapper<Resources>{

	List<Resources> findResourceListByMap(Map<String,Object> m);

	int selectAllCount();
}