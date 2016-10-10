package com.wangsong.sys.service;



import com.wangsong.sys.model.Log;
import com.wangsong.sys.util.Page;

public interface LogService extends BaseService<Log>{

	Page<Log> findLogByPage(Page<Log> page);
}
