package com.wangsong.sys.service;


import java.util.List;

import com.wangsong.sys.model.Dict;

public interface DictService extends BaseService<Dict>{

	List<Dict> findDictByDict(Dict dict);
}
