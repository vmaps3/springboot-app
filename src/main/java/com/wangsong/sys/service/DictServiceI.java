package com.wangsong.sys.service;


import java.util.List;

import com.wangsong.sys.model.Dict;
import com.wangsong.sys.util.Page;

public interface DictServiceI extends BaseServiceI<Dict>{

	Page selectAll(Page page, Dict dict);
	List<Dict> selectByDict(Dict dict);
}
