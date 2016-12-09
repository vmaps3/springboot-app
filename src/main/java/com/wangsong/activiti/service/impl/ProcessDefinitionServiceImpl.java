package com.wangsong.activiti.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;


import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.activiti.service.ProcessDefinitionService;
import com.wangsong.common.model.Page;




/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly=true)
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService{
	@Autowired
	private RepositoryService repositoryService;

	/** 查询流程定义的信息，对应表（act_re_procdef） */

	public Page<Map<String, Object>> findProcessDefinitionList(Page<Map<String, Object>> page) {
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();// 创建流程定义查询
		page.setTotalCount(processDefinitionQuery.count());
		List<ProcessDefinition> list = processDefinitionQuery.orderByProcessDefinitionVersion().asc()//
				.listPage(page.getFirst(), page.getPageSize());
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

}
