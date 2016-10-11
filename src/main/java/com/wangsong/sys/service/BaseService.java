package com.wangsong.sys.service;

import java.util.List;

import com.wangsong.sys.util.Page;




public interface BaseService<T> {
	
	List<T> selectAll();
	
	T selectByPrimaryKey(String id);
	
    int insert(T t);
    
    int updateByPrimaryKey(T t);
    
    int deleteByPrimaryKey(String[] id);

    Page<T> findTByPage(Page<T> page, T t);
	
    List<T> findTByT(T t);
    
    T findTByTOne(T t);
	
}
