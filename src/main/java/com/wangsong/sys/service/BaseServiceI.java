package com.wangsong.sys.service;

import java.util.List;




public interface BaseServiceI<T> {
	
	List<T> selectAll();
	
	T selectByPrimaryKey(String id);
	
    int insert(T t);
    
    int updateByPrimaryKey(T t);
    
    int deleteByPrimaryKey(String id);


	

	
}
