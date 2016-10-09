package com.wangsong.sys.service;

import java.util.List;




public interface BaseService<T> {
	
	List<T> selectAll();
	
	T selectByPrimaryKey(String id);
	
    int insert(T t);
    
    int updateByPrimaryKey(T t);
    
    int deleteByPrimaryKey(String[] id);


	

	
}
