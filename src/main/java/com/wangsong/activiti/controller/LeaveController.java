package com.wangsong.activiti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.task.Comment;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.wangsong.activiti.model.Leave;
import com.wangsong.activiti.service.LeaveService;
import com.wangsong.activiti.service.WorkflowService;
import com.wangsong.commons.controller.BaseController;

/**
 * 字典controller
 * @author ty
 * @date 2015年1月13日
 */
@Controller
@RequestMapping("workflow/leave")
public class LeaveController extends BaseController{
	
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private WorkflowService workflowService;
	
	
	/**
	 * 添加字典跳转
	 * 
	 * @param model
	 */
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("leave", new Leave());
		model.addAttribute("action", "create");
		List<String> buttonList=new ArrayList<String>();
		buttonList.add("提交");
		model.addAttribute("buttonList",buttonList);
		return "workflow/leave/form";
	}

	/**
	 * 添加字典
	 * 
	 * @param dict
	 * @param model
	 */
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public String create(Leave leave, Model model) {
		leaveService.save(leave);
		workflowService.workflowStartListen(leave.getClass().getSimpleName()+"."+leave.getId());
		workflowService.complete(leave.getClass().getSimpleName(), leave.getId(),"提交",null);
		return "success";
	}

	/**
	 * 修改字典跳转
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "update/{id}/{display}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Integer id, @PathVariable("display") String display,Model model) {
		//Leave leave=leaveService.get(id);
		Leave leave = null;
		String businessKey=	leave.getClass().getSimpleName()+"."+leave.getId();
		model.addAttribute("leave",leave);
		model.addAttribute("action", "update");
		List<String> buttonList=null;
		List<Map<String, Object>> commentList =null;
		if(display.equals("yes")){
			buttonList=workflowService.findOutComeListByTaskId(businessKey);
			commentList = workflowService.findCommentByBusinessKey(businessKey);
		}else{
			commentList = workflowService.findHistoryCommentByBusinessKey(businessKey);
		}
		model.addAttribute("display",display);
		/**三：查询所有历史审核人的审核信息，帮助当前人完成审核，返回List<Comment>*/
		model.addAttribute("buttonList",buttonList);
		model.addAttribute("commentList",commentList);
		return "workflow/leave/form";
	}

	/**
	 * 修改字典
	 * 
	 * @param dict
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public String update(@ModelAttribute @RequestBody Leave leave,Model model,String buttonValue,String message) {
		workflowService.complete(leave.getClass().getSimpleName(), leave.getId(),buttonValue,message);
		return "success";
	}


}
