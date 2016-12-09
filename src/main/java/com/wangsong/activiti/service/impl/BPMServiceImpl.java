package com.wangsong.activiti.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.activiti.service.BPMService;
import com.wangsong.activiti.service.HistoryService;
import com.wangsong.common.model.Page;
import com.wangsong.common.util.DateUtils;
import com.wangsong.common.util.UserUtil;
import com.wangsong.system.model.User;



/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly=true)
public class BPMServiceImpl implements BPMService{
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private FormService formService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private HistoryService historyService;
	
	// 通过流程定义ID查询对象
	public ProcessDefinition findProcessDefinitionByprocessDefinitionId(String processDefinitionId) {
		return repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
	}

	public Task findTaskByTaskId(String taskId) {
		return taskService.createTaskQuery().taskId(taskId).singleResult();

	}

	// 通过businessKey获取任务对象
	public Task findTaskBybusinessKey(String businessKey) {
		return taskService.createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
	}

	// 通过businessKey获取任务对象
	public ProcessInstance findProcessInstanceByProcessInstanceId(String processInstanceId) {
		return runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
	}


	// 保存任务
	@Transactional(readOnly = false)
	public void startProcessInstanceByKey(String name, String id,Map<String,Object>variables) {
		String businessKey = name + "." + id;
		runtimeService.startProcessInstanceByKey(name,businessKey , variables);
	}
	// 办理任务
	@Transactional(readOnly = false)
	public void complete(String name, String id, Map<String, Object> variables, String message) {
		String businessKey = name + "." + id;
		// 使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = findTaskBybusinessKey(businessKey);
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		if(message!=null){
			Authentication.setAuthenticatedUserId(((User)UserUtil.getUser()).getId().toString());
			taskService.addComment(task.getId(), processInstanceId, message);
		}
		taskService.complete(findTaskBybusinessKey(businessKey).getId(), variables);

	}
	
	// 通过任务ID获取流程图中表单URL
		public String findTaskFormKeyByTaskId(String taskId) {
			TaskFormData formData = formService.getTaskFormData(taskId);
			// 获取Form key的值
			String url = formData.getFormKey();
			return url;
		}

	/** 2：使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task> */

	public Page<Map<String, Object>> findTaskListByUserId(final Page<Map<String, Object>> page, String userId) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee(userId);
		page.setTotalCount(taskQuery.count());
		List<Task> list = taskQuery.orderByTaskCreateTime().asc().listPage(page.getFirst(), page.getPageSize());

		for (int i = 0; i < list.size(); i++) {
			Task d = list.get(i);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("assignee", d.getAssignee());
			m.put("category", d.getCategory());
			m.put("createTime", DateUtils.formatDateTime(d.getCreateTime()));
			m.put("delegationState", d.getDelegationState());
			m.put("description", d.getDescription());
			m.put("dueDate", d.getDueDate());
			m.put("executionId", d.getExecutionId());
			m.put("formKey", d.getFormKey());
			m.put("id", d.getId());
			m.put("name", d.getName());
			m.put("owner", d.getOwner());
			m.put("parentTaskId", d.getParentTaskId());
			m.put("priority", d.getPriority());
			m.put("processDefinitionId", d.getProcessDefinitionId());
			m.put("processInstanceId", d.getProcessInstanceId());
			m.put("processVariables", d.getProcessVariables());
			m.put("taskDefinitionKey", d.getTaskDefinitionKey());
			m.put("taskLocalVariables", d.getTaskLocalVariables());
			m.put("tenantId", d.getTenantId());
			ProcessDefinition processDefinition = findProcessDefinitionByprocessDefinitionId(
					d.getProcessDefinitionId());
			m.put("processDefinitionName", processDefinition.getName());
			mapList.add(m);
		}

		page.setResult(mapList);
		return page;
	}

	

	/** 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象 */
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
		// 使用任务ID，查询任务对象
		Task task = findTaskByTaskId(taskId);
		// 获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		return findProcessDefinitionByprocessDefinitionId(processDefinitionId);
	}


	// 通过任务ID获取实例ID
	public String findIdByTaskId(String taskId) {
		// 2：使用任务对象Task获取流程实例ID
		String processInstanceId = findTaskByTaskId(taskId).getProcessInstanceId();
		// 3：使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		// 4：使用流程实例对象获取BUSINESS_KEY
		String buniness_key = pi.getBusinessKey();
		String id = null;
		if (buniness_key != null) {
			// 截取字符串，取buniness_key小数点的第2个值
			id = buniness_key.split("\\.")[1];
		}
		return id;
	}

	

	/**
	 * 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
	 * map集合的key：表示坐标x,y,width,height map集合的value：表示坐标对应的值
	 */
	public Map<String, Object> findCoordingByTaskId(String taskId) {
		
		// 使用任务ID，查询任务对象
		Task task = findTaskByTaskId(taskId);
		// 获取流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();
		String processInstanceId = task.getProcessInstanceId();
		return findcoordingByProcessDefinitionIdProcessInstanceId(processDefinitionId,processInstanceId);
	}

	
	
	public Map<String , Object> findcoordingByProcessDefinitionIdProcessInstanceId(String processDefinitionId,String processInstanceId){
		// 存放坐标
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		// 流程实例ID
		
		// 使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = findProcessInstanceByProcessInstanceId(processInstanceId);// 使用流程实例ID查询
		// 获取当前活动的ID
		String activityId = pi.getActivityId();
		// 获取当前活动对象
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);// 活动ID
		// 获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
		return map;
	}
	/** 获取批注信息，传递的是当前任务ID，获取历史任务ID对应的批注 */

	public List<Map<String, Object>> findCommentByBusinessKey(String businessKey) {

		// 使用当前的任务ID，查询当前流程对应的历史任务ID
		// 使用当前任务ID，获取当前任务对象
		Task task = findTaskBybusinessKey(businessKey);
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		return historyService.findHistoryCommentByProcessInstanceId(processInstanceId);
	}


}
