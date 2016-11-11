package com.wangsong.sys.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;

@ContextConfiguration(locations = { "/spring.xml" })
public class BMS2Test extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ProcessEngine processEngineFactory;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
    private IdentityService identityService;
	@Autowired
    private ManagementService managementService;
	@Autowired
    private FormService formService;
	
	

	@Test
	public void hi() throws Exception {
		HistoricTaskInstanceQuery histTaskQuery = historyService.createHistoricTaskInstanceQuery().taskAssignee("1").finished()
				.includeProcessVariables().orderByHistoricTaskInstanceEndTime().desc();
		List<HistoricTaskInstance> histList = histTaskQuery.list();
		for(int i=0;i<histList.size();i++){
			System.out.println(histList.get(i).getId()+"|"+histList.get(i).getName());
		}
		
		
	}
	
}