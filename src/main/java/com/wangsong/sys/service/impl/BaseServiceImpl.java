package com.wangsong.sys.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.BaseMapper;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.BaseService;
import com.wangsong.sys.util.Page;


@Service
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T>{
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
		String id = UUID.randomUUID().toString();
		Field field;
		try {
			field = t.getClass().getDeclaredField("id");
			field.setAccessible(true);
			field.set(t, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    	return baseMapper.insert(t);
    	
    }
	@Override
    public int updateByPrimaryKey(T t){
    	return baseMapper.updateByPrimaryKey(t);
    	
    }
    @Override
    public int deleteByPrimaryKey(String[] id){
    	return baseMapper.deleteByPrimaryKey(id);
    	
    }


    @Override
	public Page<T> findTByPage(Page<T> page,T t) {	
    	page.setT(t);
		List<User> userList=baseMapper.findTByPage(page);
		page.setResult(userList);
		int  count=baseMapper.findTCountByT(page.getT());
		page.setTotalCount(count);
		return page;
	}

	
}
