package com.wangsong.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.DictMapper;
import com.wangsong.sys.dao.UserMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.Dict;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import com.wangsong.sys.service.DictService;
import com.wangsong.sys.util.Page;


@Service
@Transactional
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService{
	@Autowired
	private DictMapper dictMapper;
	
	
	
	@Override
	public Page<Dict> findDictByDict(Page<Dict> page) {	
		 List<Dict> userList=dictMapper.findDictByPage(page);
		 page.setResult(userList);
		 int  count=dictMapper.findDictCountByDict(page.getT());
		 page.setTotalCount(count);
		 return page;
	}



	@Override
	public List<Dict> findDictByDict(Dict dict) {
		return dictMapper.findDictByDict(dict);
	}


}
