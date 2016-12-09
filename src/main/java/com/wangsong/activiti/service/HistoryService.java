package com.wangsong.activiti.service;

import java.util.List;
import java.util.Map;


import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;


import com.wangsong.common.model.Page;
/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
public interface HistoryService {


	public HistoricTaskInstance findHistoricTaskInstanceByTaskId(String taskId);

	public HistoricProcessInstance findHistoricProcessInstanceByProcessInstanceId(String processInstanceId);

	public ProcessInstance findProcessInstanceByTaskId(String taskId);

	public HistoricProcessInstance findHistoricProcessInstanceByBusinessKey(String businessKey);

	public Page<Map<String, Object>> findHistoryTaskListByUserId(Page<Map<String, Object>> page, String userId);

	/** 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象 */
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId);

	/** 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象 */
	public ProcessDefinition findHistoryProcessDefinitionByTaskId(String taskId);

	public String findHistoryIdByTaskId(String processInstanceId);

	public Map<String, Object> findHistoryCoordingByTaskId(String taskId);

	/** 获取批注信息，传递的是当前任务ID，获取历史任务ID对应的批注 */

	/** 使用请假单ID，查询历史批注信息 */

	public List<Map<String, Object>> findHistoryCommentByBusinessKey(String businessKey);

	public List<Map<String, Object>> findHistoryCommentByProcessInstanceId(String processInstanceId);

}
