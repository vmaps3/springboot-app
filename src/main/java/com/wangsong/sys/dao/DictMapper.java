package com.wangsong.sys.dao;

import java.util.List;

import com.wangsong.sys.model.Dict;

public interface DictMapper extends BaseMapper<Dict>{

	int selectAllCount(Dict dict);
	List<Dict> selectByDict(Dict dict);    
}