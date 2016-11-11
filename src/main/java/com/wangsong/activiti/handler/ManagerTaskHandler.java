package com.wangsong.activiti.handler;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wangsong.sys.service.UserService;




/**
 * 员工经理任务分配
 *
 */
@SuppressWarnings("serial")
public class ManagerTaskHandler implements TaskListener {
	
	
	@Override
	public void notify(DelegateTask delegateTask) {
		//UserService userService = (UserService)SpringContextUtil.getBean("userService");
		//List<String> userId=userService.findUserIdByUserIdRoleCode(UserUtil.getCurrentUser().getId(),"70002");
		//delegateTask.setAssignee(userId.get(0));
		
	}

}
