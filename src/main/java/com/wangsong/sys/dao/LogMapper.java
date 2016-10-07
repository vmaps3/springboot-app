package com.wangsong.sys.dao;

import com.wangsong.sys.model.Log;

public interface LogMapper  extends BaseMapper<Log>{

	int selectAllCount();
   
}