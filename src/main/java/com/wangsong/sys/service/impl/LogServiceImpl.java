package com.wangsong.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.DictMapper;
import com.wangsong.sys.dao.LogMapper;
import com.wangsong.sys.dao.UserMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.Dict;
import com.wangsong.sys.model.Log;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import com.wangsong.sys.service.LogService;
import com.wangsong.sys.util.Page;


@Service
@Transactional
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService{
	@Autowired
	private LogMapper logMapper;
	
	
	
	@Override
	public Page<Log> findLogByPage(Page<Log> page) {	
		 //PageHelper.startPage(page.getPageNo(), page.getPageSize());
		 List<Log> userList=logMapper.findLogByPage(page);
		 page.setResult(userList);
		 int  count=logMapper.findLogCount();
		 page.setTotalCount(count);
		 return page;
	}
}
