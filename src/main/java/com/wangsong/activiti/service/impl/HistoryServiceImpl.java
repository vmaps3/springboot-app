package com.wangsong.activiti.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.activiti.service.BPMService;
import com.wangsong.common.model.Page;
import com.wangsong.common.util.DateUtils;
import com.wangsong.system.model.User;
import com.wangsong.system.service.UserService;



/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly=true)
public class HistoryServiceImpl implements com.wangsong.activiti.service.HistoryService{
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private UserService userService;
	@Autowired
	private BPMService bpmService;

	public HistoricTaskInstance findHistoricTaskInstanceByTaskId(String taskId) {
		return historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
	}

	public HistoricProcessInstance findHistoricProcessInstanceByProcessInstanceId(String processInstanceId) {
		return historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
	}

	public ProcessInstance findProcessInstanceByTaskId(String taskId) {
		HistoricTaskInstance historicTaskInstance = findHistoricTaskInstanceByTaskId(taskId);
		return bpmService.findProcessInstanceByProcessInstanceId(historicTaskInstance.getProcessInstanceId());
	}

	public HistoricProcessInstance findHistoricProcessInstanceByBusinessKey(String businessKey) {
		return historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(businessKey).singleResult();
	}

	public Page<Map<String, Object>> findHistoryTaskListByUserId(Page<Map<String, Object>> page,
			String userId) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		HistoricTaskInstanceQuery histTaskQuery = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId)
				.finished();

		page.setTotalCount(histTaskQuery.count());
		List<HistoricTaskInstance> histList = histTaskQuery.includeProcessVariables()
				.orderByHistoricTaskInstanceEndTime().desc().listPage(page.getFirst(), page.getPageSize());
		for (int i = 0; i < histList.size(); i++) {
			HistoricTaskInstance historicTaskInstance = histList.get(i);
			Map<String, Object> map = new HashMap<>();
			map.put("assignee", historicTaskInstance.getAssignee());
			map.put("category", historicTaskInstance.getCategory());
			map.put("claimTime", historicTaskInstance.getClaimTime());
			map.put("createTime", DateUtils.formatDateTime(historicTaskInstance.getCreateTime()));
			map.put("deleteReason", historicTaskInstance.getDeleteReason());
			map.put("description", historicTaskInstance.getDescription());
			map.put("dueDate", historicTaskInstance.getDueDate());
			map.put("durationInMillis", historicTaskInstance.getDurationInMillis());
			map.put("endTime", historicTaskInstance.getEndTime());
			map.put("executionId", historicTaskInstance.getExecutionId());
			map.put("formKey", historicTaskInstance.getFormKey());
			map.put("id", historicTaskInstance.getId());
			map.put("name", historicTaskInstance.getName());
			map.put("owner", historicTaskInstance.getOwner());
			map.put("priority", historicTaskInstance.getParentTaskId());
			map.put("priority", historicTaskInstance.getPriority());
			map.put("processDefinitionId", historicTaskInstance.getProcessDefinitionId());
			map.put("processInstanceId", historicTaskInstance.getProcessInstanceId());
			map.put("processVariables", historicTaskInstance.getProcessVariables());
			map.put("startTime", historicTaskInstance.getStartTime());
			map.put("taskDefinitionKey", historicTaskInstance.getTaskDefinitionKey());
			map.put("taskLocalVariables", historicTaskInstance.getTaskLocalVariables());
			map.put("tenantId", historicTaskInstance.getTenantId());
			map.put("time", historicTaskInstance.getTime());
			map.put("workTimeInMillis", historicTaskInstance.getWorkTimeInMillis());
			ProcessDefinition processDefinition = bpmService.findProcessDefinitionByprocessDefinitionId(
					historicTaskInstance.getProcessDefinitionId());
			map.put("processDefinitionName", processDefinition.getName());
			mapList.add(map);

		}

		page.setResult(mapList);
		return page;
	}

	/** 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象 */
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
		// 使用任务ID，查询任务对象
		Task task = bpmService.findTaskByTaskId(taskId);
		// 获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		return bpmService.findProcessDefinitionByprocessDefinitionId(processDefinitionId);
	}

	/** 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象 */
	public ProcessDefinition findHistoryProcessDefinitionByTaskId(String taskId) {
		// 使用任务ID，查询任务对象
		HistoricTaskInstance task = findHistoricTaskInstanceByTaskId(taskId);
		// 获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		return bpmService.findProcessDefinitionByprocessDefinitionId(processDefinitionId);
	}

	public String findHistoryIdByTaskId(String processInstanceId) {
		// 3：使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
		HistoricProcessInstance historicProcessInstance = findHistoricProcessInstanceByProcessInstanceId(
				processInstanceId);

		// 4：使用流程实例对象获取BUSINESS_KEY
		String buniness_key = historicProcessInstance.getBusinessKey();
		String id = null;
		if (buniness_key != null) {
			// 截取字符串，取buniness_key小数点的第2个值
			id = buniness_key.split("\\.")[1];
		}
		return id;
	}

	public Map<String, Object> findHistoryCoordingByTaskId(String taskId) {
		// 使用任务ID，查询任务对象
		HistoricTaskInstance historicTaskInstance = findHistoricTaskInstanceByTaskId(taskId);
		// 获取流程定义的ID
		String processDefinitionId = historicTaskInstance.getProcessDefinitionId();
		String processInstanceId = historicTaskInstance.getProcessInstanceId();
		return bpmService.findcoordingByProcessDefinitionIdProcessInstanceId(processDefinitionId,processInstanceId);
	}

	/** 使用请假单ID，查询历史批注信息 */

	public List<Map<String, Object>> findHistoryCommentByBusinessKey(String businessKey) {

		/** 1:使用历史的流程实例查询，返回历史的流程实例对象，获取流程实例ID */
		HistoricProcessInstance hpi = findHistoricProcessInstanceByBusinessKey(businessKey);
		// 流程实例ID
		String processInstanceId = hpi.getId();
		
		return findHistoryCommentByProcessInstanceId(processInstanceId);
	}
	public  List<Map<String, Object>> findHistoryCommentByProcessInstanceId(String processInstanceId){
		List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
		List<Map<String, Object>> mapList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Comment comment = list.get(i);
			Map<String, Object> map = new HashMap<>();
			map.put("fullMessage", comment.getFullMessage());
			map.put("id", comment.getId());
			map.put("processInstanceId", comment.getProcessInstanceId());
			map.put("taskId", comment.getTaskId());
			map.put("time", DateUtils.formatDateTime(comment.getTime()));
			map.put("type", comment.getType());
			map.put("userId", comment.getUserId());
			User user=new User();
			user.setId(comment.getUserId());
			map.put("userName", userService.findTByTOne(user).getUsername());
			mapList.add(map);
		}
		return mapList;
		
	}

}
