package com.wangsong.sys.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.wangsong.sys.dao.DictMapper;
import com.wangsong.sys.dao.UserMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.Dict;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import com.wangsong.sys.util.Page;


@Service
@Transactional
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictServiceI{
	@Autowired
	private DictMapper dictMapper;
	
	
	
	@Override
	public Page findDictByDict(Page page,Dict dict) {	
		 PageHelper.startPage(page.getPageNo(), page.getPageSize());
		 List<Dict> userList=dictMapper.findDictByDict(dict);
		 page.setResult(userList);
		 int  count=dictMapper.findDictCountByDict(dict);
		 page.setTotalCount(count);
		 return page;
	}



	@Override
	public List<Dict> findDictByDict(Dict dict) {
		return dictMapper.findDictByDict(dict);
	}


}
