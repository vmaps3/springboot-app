package com.wangsong.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.DictMapper;
import com.wangsong.sys.model.Dict;
import com.wangsong.sys.service.DictService;

@Service
@Transactional
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService{
	@Autowired
	private DictMapper dictMapper;

	@Override
	public List<Dict> findDictByDict(Dict dict) {
		return dictMapper.findDictByDict(dict);
	}


}
