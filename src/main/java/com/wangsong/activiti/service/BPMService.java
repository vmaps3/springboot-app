package com.wangsong.activiti.service;

import java.util.List;
import java.util.Map;


import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.wangsong.common.model.Page;
/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
public interface BPMService {

	// 通过流程定义ID查询对象
	public ProcessDefinition findProcessDefinitionByprocessDefinitionId(String processDefinitionId);

	public Task findTaskByTaskId(String taskId);

	// 通过businessKey获取任务对象
	public Task findTaskBybusinessKey(String businessKey);

	// 通过businessKey获取任务对象
	public ProcessInstance findProcessInstanceByProcessInstanceId(String processInstanceId);

	// 保存任务
	public void startProcessInstanceByKey(String name, String id, Map<String, Object> variables);

	// 办理任务
	public void complete(String name, String id, Map<String, Object> variables, String message);

	// 通过任务ID获取流程图中表单URL
	public String findTaskFormKeyByTaskId(String taskId);


	/** 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象 */
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId);

	// 通过任务ID获取实例ID
	public String findIdByTaskId(String taskId);
	/**
	 * 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
	 * map集合的key：表示坐标x,y,width,height map集合的value：表示坐标对应的值
	 */
	public Map<String, Object> findCoordingByTaskId(String taskId);

	public Map<String, Object> findcoordingByProcessDefinitionIdProcessInstanceId(String processDefinitionId,String processInstanceId);

	public Page<Map<String, Object>> findTaskListByUserId(final Page<Map<String, Object>> page, String userId);

	/** 获取批注信息，传递的是当前任务ID，获取历史任务ID对应的批注 */

	public List<Map<String, Object>> findCommentByBusinessKey(String businessKey);

}
