package com.wangsong.sys.dao;

import com.wangsong.sys.model.User;
import com.wangsong.sys.util.Page;

import java.util.List;

public interface BaseMapper<T> {
    int deleteByPrimaryKey(String id);

    int insert(T t);

    T selectByPrimaryKey(String id);

    List<T> selectAll();

    int updateByPrimaryKey(T t);


}