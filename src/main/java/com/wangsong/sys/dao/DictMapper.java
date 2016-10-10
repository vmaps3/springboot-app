package com.wangsong.sys.dao;

import java.util.List;

import com.wangsong.sys.model.Dict;
import com.wangsong.sys.util.Page;

public interface DictMapper extends BaseMapper<Dict>{

	int findDictCountByDict(Dict dict);
	List<Dict> findDictByDict(Dict dict);
	List<Dict> findDictByPage(Page<Dict> page);    
}