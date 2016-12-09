package com.wangsong.activiti.service;

import java.util.Map;


import org.springframework.web.multipart.MultipartFile;

import com.wangsong.common.model.Page;
/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
public interface DeploymentService {

	public void saveNewDeploye(MultipartFile file, String filename);

	// 流程部署查询
	public Page<Map<String, Object>> findDeploymentList(Page<Map<String, Object>> page);

	// 强制删除流程定义
	public void deleteProcessDefinitionByDeploymentId(String id);
}
