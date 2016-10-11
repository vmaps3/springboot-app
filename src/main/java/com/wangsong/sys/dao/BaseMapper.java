package com.wangsong.sys.dao;

import java.util.List;

import com.wangsong.sys.model.User;
import com.wangsong.sys.util.Page;

public interface BaseMapper<T> {
    int deleteByPrimaryKey(String[] ids);

    int insert(T t);

    T selectByPrimaryKey(String id);

    List<T> selectAll();

    int updateByPrimaryKey(T t);

	List<User> findTByPage(Page<T> page);

	int findTCountByT(T t);


}