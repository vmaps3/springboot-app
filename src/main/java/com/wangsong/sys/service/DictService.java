package com.wangsong.sys.service;


import java.util.List;

import com.wangsong.sys.model.Dict;
import com.wangsong.sys.util.Page;

public interface DictService extends BaseService<Dict>{

	Page findDictByDict(Page page, Dict dict);
	List<Dict> findDictByDict(Dict dict);
}