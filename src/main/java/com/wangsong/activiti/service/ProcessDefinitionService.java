package com.wangsong.activiti.service;

import java.io.InputStream;
import java.util.Map;


import com.wangsong.common.model.Page;
/**
 * 字典service
 * 
 * @author ty
 * @date 2015年1月13日
 */
public interface ProcessDefinitionService {
	/** 查询流程定义的信息，对应表（act_re_procdef） */

	public Page<Map<String, Object>> findProcessDefinitionList(Page<Map<String, Object>> page);

	/** 使用部署对象ID和资源图片名称，获取图片的输入流 */
	public InputStream findImageInputStream(String deploymentId, String imageName);
}
