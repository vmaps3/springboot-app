package com.wangsong.sys.dao;

import java.util.List;

import com.wangsong.sys.model.Dict;

public interface DictMapper extends BaseMapper<Dict>{

	int findDictCountByDict(Dict dict);
	List<Dict> findDictByDict(Dict dict);    
}