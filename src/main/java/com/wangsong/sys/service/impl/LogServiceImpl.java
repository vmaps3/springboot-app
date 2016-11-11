package com.wangsong.sys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.commons.service.impl.BaseServiceImpl;
import com.wangsong.sys.model.Log;
import com.wangsong.sys.service.LogService;

@Service
@Transactional
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService{
	
}
