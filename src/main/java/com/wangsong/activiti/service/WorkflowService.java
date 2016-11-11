package com.wangsong.activiti.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wangsong.commons.util.DateUtil;
import com.wangsong.commons.util.Page;
import com.wangsong.commons.util.UserUtil;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.UserService;



/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly=true)
public class WorkflowService {
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
	@Autowired
	private UserService userService;

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

	public HistoricTaskInstance findHistoricTaskInstanceByTaskId(String taskId) {
		return historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
	}

	public HistoricProcessInstance findHistoricProcessInstanceByProcessInstanceId(String processInstanceId) {
		return historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
	}

	public ProcessInstance findProcessInstanceByTaskId(String taskId) {
		HistoricTaskInstance historicTaskInstance = findHistoricTaskInstanceByTaskId(taskId);
		return findProcessInstanceByProcessInstanceId(historicTaskInstance.getProcessInstanceId());
	}

	public HistoricProcessInstance findHistoricProcessInstanceByBusinessKey(String businessKey) {
		return historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(businessKey).singleResult();
	}

	// 流程部署查询
	public Page<Map<String, Object>> findDeploymentList(Page<Map<String, Object>> page) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();// 创建部署对象查询

		page.setTotalCount(deploymentQuery.count());
		List<Deployment> list = deploymentQuery.orderByDeploymenTime().asc()//
				.listPage(page.getFirst() - 1, page.getPageSize());

		for (int i = 0; i < list.size(); i++) {
			Deployment d = list.get(i);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", d.getId());
			m.put("name", d.getName());
			m.put("deploymentTime", d.getDeploymentTime());
			m.put("category", d.getCategory());
			m.put("tenantId", d.getTenantId());
			mapList.add(m);
		}
		page.setResult(mapList);
		return page;
	}
	/** 部署流程定义 */
	@Transactional(readOnly = false)
	public void saveNewDeploye(MultipartFile file, String filename) {
		try {
			// 2：将File类型的文件转化成ZipInputStream流
			ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream());
			repositoryService.createDeployment()// 创建部署对象
					.name(filename)// 添加部署名称
					.addZipInputStream(zipInputStream)//
					.deploy();// 完成部署
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 查询流程定义的信息，对应表（act_re_procdef） */

	public Page<Map<String, Object>> findProcessDefinitionList(Page<Map<String, Object>> page) {
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();// 创建流程定义查询
		page.setTotalCount(processDefinitionQuery.count());
		List<ProcessDefinition> list = processDefinitionQuery.orderByProcessDefinitionVersion().asc()//
				.listPage(page.getFirst() - 1, page.getPageSize());
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			ProcessDefinition p = list.get(i);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", p.getId());
			m.put("name", p.getName());
			m.put("key", p.getKey());
			m.put("category", p.getCategory());
			m.put("deploymentId", p.getDeploymentId());
			m.put("description", p.getDescription());
			m.put("diagramResourceName", p.getDiagramResourceName());
			m.put("resourceName", p.getResourceName());
			m.put("tenantId", p.getTenantId());
			m.put("version", p.getVersion());
			mapList.add(m);
		}
		page.setResult(mapList);
		return page;
	}

	/** 使用部署对象ID和资源图片名称，获取图片的输入流 */
	public InputStream findImageInputStream(String deploymentId, String imageName) {
		return repositoryService.getResourceAsStream(deploymentId, imageName);
	}
	// 强制删除流程定义
	@Transactional(readOnly = false)
	public void deleteProcessDefinitionByDeploymentId(String id) {
		repositoryService.deleteDeployment(id, true);
	}

	// 通过任务ID获取流程图中表单URL
	public String findTaskFormKeyByTaskId(String taskId) {
		TaskFormData formData = formService.getTaskFormData(taskId);
		// 获取Form key的值
		String url = formData.getFormKey();
		return url;
	}

	/**
	 * 二：已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中
	 */
	public List<String> findOutComeListByTaskId(String businessKey) {

		// 返回存放连线的名称集合
		List<String> list = new ArrayList<String>();
		Task task = findTaskBybusinessKey(businessKey);
		// 2：获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 3：查询ProcessDefinitionEntiy对象
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		// 使用任务对象Task获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
		ProcessInstance pi = findProcessInstanceByProcessInstanceId(processInstanceId);
		// 获取当前活动的id
		String activityId = pi.getActivityId();
		// 4：获取当前的活动
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
		// 5：获取当前活动完成之后连线的名称
		List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
		if (pvmList != null && pvmList.size() > 0) {
			for (PvmTransition pvm : pvmList) {
				String name = (String) pvm.getProperty("name");
				list.add(name);
			}
		}
		return list;
	}
	// 保存任务
	@Transactional(readOnly = false)
	public void startProcessInstanceByKey(String name, Integer id) {

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("inputUser", UserUtil.getUser().getId().toString());// 表示惟一用户
		String businessKey = name + "." + id;
		runtimeService.startProcessInstanceByKey(name,businessKey , variables);
		
	}
	// 办理任务
	@Transactional(readOnly = false)
	public void complete(String name, Integer id, String buttonValue, String message) {

		String businessKey = name + "." + id;
		// 使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = findTaskBybusinessKey(businessKey);
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		if(message!=null){
			Authentication.setAuthenticatedUserId(UserUtil.getUser().getId().toString());
			taskService.addComment(task.getId(), processInstanceId, message);
		}
		Map<String, Object> variables = new HashMap<String, Object>();
		if (!buttonValue.equals("提交")) {
			variables.put("message", buttonValue);
		}
		taskService.complete(findTaskBybusinessKey(businessKey).getId(), variables);

	}

	/** 2：使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task> */

	public Page<Map<String, Object>> findTaskListByUserId(final Page<Map<String, Object>> page,
String userId) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee(userId);
		page.setTotalCount(taskQuery.count());
		List<Task> list = taskQuery.orderByTaskCreateTime().asc().listPage(page.getFirst() - 1, page.getPageSize());

		for (int i = 0; i < list.size(); i++) {
			Task d = list.get(i);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("assignee", d.getAssignee());
			m.put("category", d.getCategory());
			m.put("createTime", DateUtil.dateToString(d.getCreateTime()));
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

	public Page<Map<String, Object>> findHistoryTaskListByUserId(Page<Map<String, Object>> page,
			String userId) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		HistoricTaskInstanceQuery histTaskQuery = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId)
				.finished();

		page.setTotalCount(histTaskQuery.count());
		List<HistoricTaskInstance> histList = histTaskQuery.includeProcessVariables()
				.orderByHistoricTaskInstanceEndTime().desc().listPage(page.getFirst() - 1, page.getPageSize());
		for (int i = 0; i < histList.size(); i++) {
			HistoricTaskInstance historicTaskInstance = histList.get(i);
			Map<String, Object> map = new HashMap<>();
			map.put("assignee", historicTaskInstance.getAssignee());
			map.put("category", historicTaskInstance.getCategory());
			map.put("claimTime", historicTaskInstance.getClaimTime());
			map.put("createTime", DateUtil.dateToString(historicTaskInstance.getCreateTime()));
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
			ProcessDefinition processDefinition = findProcessDefinitionByprocessDefinitionId(
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
		Task task = findTaskByTaskId(taskId);
		// 获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		return findProcessDefinitionByprocessDefinitionId(processDefinitionId);
	}

	/** 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象 */
	public ProcessDefinition findHistoryProcessDefinitionByTaskId(String taskId) {
		// 使用任务ID，查询任务对象
		HistoricTaskInstance task = findHistoricTaskInstanceByTaskId(taskId);
		// 获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		return findProcessDefinitionByprocessDefinitionId(processDefinitionId);
	}

	// 通过任务ID获取实例ID
	public Integer findIdByTaskId(String taskId) {
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
		return Integer.valueOf(id);
	}

	public Integer findHistoryIdByTaskId(String processInstanceId) {
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
		return Integer.valueOf(id);
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

	public Map<String, Object> findHistoryCoordingByTaskId(String taskId) {
		// 使用任务ID，查询任务对象
		HistoricTaskInstance historicTaskInstance = findHistoricTaskInstanceByTaskId(taskId);
		// 获取流程定义的ID
		String processDefinitionId = historicTaskInstance.getProcessDefinitionId();
		String processInstanceId = historicTaskInstance.getProcessInstanceId();
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
		return findHistoryCommentByProcessInstanceId(processInstanceId);
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
			map.put("time", DateUtil.dateToString(comment.getTime()));
			map.put("type", comment.getType());
			map.put("userId", comment.getUserId());
			User user=new User();
			user.setId(comment.getUserId());
			map.put("userName", userService.findTByTOne(user).getUsername());
			mapList.add(map);
		}
		return mapList;
		
	}
	
	public boolean workflowStartListen (String businessKey ){
		for(;;){
			if(findTaskBybusinessKey(businessKey)!=null){
				return true;
			}
		}
	}
	
	
}
