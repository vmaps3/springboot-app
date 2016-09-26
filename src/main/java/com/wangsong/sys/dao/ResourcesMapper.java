package com.wangsong.sys.dao;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.BaseServiceI;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper extends BaseMapper<Resources>{

	List<String> findResourceListByRoleId(String roleId);

	List<Resources> findResourceListByType(User user);

	int selectAllCount();
}