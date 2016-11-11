package com.wangsong.activiti.handler;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wangsong.commons.util.SpringContextUtil;
import com.wangsong.commons.util.UserUtil;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.UserService;




/**
 * 员工经理任务分配
 *
 */
@SuppressWarnings("serial")
public class ManagerTaskHandler implements TaskListener {
	
	
	@Override
	public void notify(DelegateTask delegateTask) {
		
		delegateTask.setAssignee("18151fda-09e7-4491-a7dd-4e2bdd02ecc8");
		
	}

}
