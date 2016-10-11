package com.wangsong.sys.dao;

import java.util.List;

import com.wangsong.sys.model.Dict;

public interface DictMapper extends BaseMapper<Dict>{
	
	List<Dict> findDictByDict(Dict dict);
}