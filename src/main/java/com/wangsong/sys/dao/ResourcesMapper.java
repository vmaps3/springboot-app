package com.wangsong.sys.dao;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.User;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resources record);

    Resources selectByPrimaryKey(String id);

    List<Resources> selectAll();

    int updateByPrimaryKey(Resources record);

	List<String> findResourceListByRoleId(String roleId);

	List<Resources> findResourceListByType(User user);
}