package com.wangsong.sys.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.BaseMapper;
import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.util.JsonTreeData;
import com.wangsong.sys.util.Page;


public interface BaseServiceI<T> {
	
	List<T> selectAll();
	
	T selectByPrimaryKey(String id);
	
    int insert(T t);
    
    int updateByPrimaryKey(T t);
    
    int deleteByPrimaryKey(String id);


	

	
}
