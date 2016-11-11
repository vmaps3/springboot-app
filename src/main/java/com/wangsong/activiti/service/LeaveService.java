package com.wangsong.activiti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.wangsong.activiti.model.Leave;
import com.wangsong.commons.service.impl.BaseServiceImpl;



/**
 * 字典service
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly=true)
public class LeaveService extends BaseServiceImpl<Leave>{
	

	
	@Autowired
	private WorkflowService workflowService;
	
	
	/**更新请假状态，启动流程实例，让启动的流程实例关联业务*/
	@Transactional(readOnly = false)
	public void save(Leave leave) {
		//leaveDao.save(leave);
		workflowService.startProcessInstanceByKey(leave.getClass().getSimpleName(), leave.getId());
		
	}
}
