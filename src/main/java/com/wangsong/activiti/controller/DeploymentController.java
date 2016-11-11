package com.wangsong.activiti.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.wangsong.activiti.service.WorkflowService;
import com.wangsong.commons.controller.BaseController;
import com.wangsong.commons.util.Page;

/**
 * 字典controller
 * @author ty
 * @date 2015年1月13日
 */
@Controller
@RequestMapping("workflow/deployment")
public class DeploymentController extends BaseController{
	
	@Autowired
	private WorkflowService workflowService;
	
	/**
	 * 默认页面
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "workflow/deployment/list";
	}

	/**
	 * 获取字典json
	 */
	@RequiresPermissions("workflow:deployment:view")
	@RequestMapping(value="json",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request) {
		Page<Map<String,Object>> page = getPage(request);
		//1:查询部署对象信息，对应表（act_re_deployment）
		page = workflowService.findDeploymentList(page);
		//2:查询流程定义的信息，对应表（act_re_procdef）
		
		return getEasyUIData(page);
	}
	
	/**
	 * 添加字典跳转
	 * 
	 * @param model
	 */
	@RequiresPermissions("workflow:deployment:add")
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("action", "create");
		return "workflow/deployment/form";
	}

	/**
	 * 添加字典
	 * 
	 * @param dict
	 * @param model
	 */
	@RequiresPermissions("workflow:deployment:add")
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public String create(MultipartFile file,String filename, Model model) {
		workflowService.saveNewDeploye(file ,filename);
		return "success";
	}


	
	/**
	 * 删除字典
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("workflow:deployment:delete")
	@RequestMapping(value = "delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") String id) {
		
		workflowService.deleteProcessDefinitionByDeploymentId(id);
		return "success";
	}
}
