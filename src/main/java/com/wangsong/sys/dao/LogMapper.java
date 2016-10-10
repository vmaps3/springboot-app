package com.wangsong.sys.dao;

import java.util.List;

import com.wangsong.sys.model.Log;
import com.wangsong.sys.util.Page;

public interface LogMapper  extends BaseMapper<Log>{

	int findLogCount();

	List<Log> selectAll(Page page);
   
}