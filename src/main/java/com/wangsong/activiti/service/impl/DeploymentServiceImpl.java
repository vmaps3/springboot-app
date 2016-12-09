package com.wangsong.activiti.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wangsong.activiti.service.DeploymentService;
import com.wangsong.common.model.Page;




/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly=true)
public class DeploymentServiceImpl implements DeploymentService{
	@Autowired
	private RepositoryService repositoryService;
	

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
	
	// 流程部署查询
	public Page<Map<String, Object>> findDeploymentList(Page<Map<String, Object>> page) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();// 创建部署对象查询

		page.setTotalCount(deploymentQuery.count());
		List<Deployment> list = deploymentQuery.orderByDeploymenTime().asc()//
				.listPage(page.getFirst(), page.getPageSize());

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
	
	// 强制删除流程定义
		@Transactional(readOnly = false)
		public void deleteProcessDefinitionByDeploymentId(String id) {
			repositoryService.deleteDeployment(id, true);
		}

	

}
