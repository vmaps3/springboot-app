package com.wangsong.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.BaseMapper;
import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.util.JsonTreeData;
import com.wangsong.sys.util.Page;

@Service
@Transactional
public abstract class BaseServiceImpl<T> implements BaseServiceI<T>{
	@Autowired
    protected BaseMapper<T> baseMapper;
	@Override
	public List<T> selectAll(){
		return baseMapper.selectAll();
		
	}
	@Override
	public T selectByPrimaryKey(String id){
		return baseMapper.selectByPrimaryKey(id);
		
	}
	@Override
    public int insert(T t){
    	return baseMapper.insert(t);
    	
    }
	@Override
    public int updateByPrimaryKey(T t){
    	return baseMapper.updateByPrimaryKey(t);
    	
    }
    @Override
    public int deleteByPrimaryKey(String id){
    	return baseMapper.deleteByPrimaryKey(id);
    	
    }


	

	
}
