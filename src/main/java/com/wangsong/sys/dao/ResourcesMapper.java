package com.wangsong.sys.dao;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.User;

import java.util.List;

public interface ResourcesMapper extends BaseMapper<Resources>{

	List<String> findResourceListByRoleId(String roleId);

	List<Resources> findResourceListByType(User user);

	int selectAllCount();
}