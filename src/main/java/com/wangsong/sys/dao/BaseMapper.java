package com.wangsong.sys.dao;

import java.util.List;

public interface BaseMapper<T> {
    int deleteByPrimaryKey(String[] ids);

    int insert(T t);

    T selectByPrimaryKey(String id);

    List<T> selectAll();

    int updateByPrimaryKey(T t);


}