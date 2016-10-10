package com.wangsong.sys.service;


import java.util.List;

import com.wangsong.sys.model.Dict;
import com.wangsong.sys.util.Page;

public interface DictService extends BaseService<Dict>{

	Page<Dict> findDictByDict(Page<Dict> page);
	List<Dict> findDictByDict(Dict dict);
}
