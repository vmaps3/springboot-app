package com.wangsong.activiti.service;

import com.wangsong.activiti.model.Leave;
import com.wangsong.common.service.BaseService;




/**
 * 字典service
 * @author ty
 * @date 2015年1月13日
 */

public interface LeaveService extends BaseService<Leave>{
	public void save(Leave leave) ;
}
