package com.wangsong.activiti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.wangsong.activiti.model.Leave;
import com.wangsong.activiti.service.LeaveService;
import com.wangsong.activiti.service.ActivitiService;
import com.wangsong.commons.controller.BaseController;
import com.wangsong.commons.util.UserUtil;

/**
 * 字典controller
 * @author ty
 * @date 2015年1月13日
 */
@Controller
@RequestMapping("/activiti/leave")
public class LeaveController extends BaseController{
	
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private ActivitiService workflowService;
	

	@RequestMapping(value = "/toAdd")
	public String createForm(Model model) {		
		return "activiti/leave/add";
	}

	@RequestMapping(value = "/add")
	@ResponseBody
	public String create(Leave leave, Model model) {
		leaveService.save(leave);
		return "success";
	}

	
	@RequestMapping(value = "/toExamine")
	public String updateForm(String id,  String display,Model model) {
		Leave leave=leaveService.selectByPrimaryKey(id);
		String businessKey=	leave.getClass().getSimpleName()+"."+leave.getId();
		model.addAttribute("leave",leave);
		List<Map<String, Object>> commentList =null;
		if(display.equals("yes")){
			commentList = workflowService.findCommentByBusinessKey(businessKey);
			model.addAttribute("commentList",commentList);
			return "activiti/leave/examine";
		}else{
			commentList = workflowService.findHistoryCommentByBusinessKey(businessKey);
			model.addAttribute("commentList",commentList);
			return "activiti/leave/history";
		}	
	}

	@RequestMapping(value = "/examine", method = RequestMethod.POST)
	@ResponseBody
	public String examine(@ModelAttribute @RequestBody Leave leave,Model model,String buttonValue,String message) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("message", buttonValue);
		variables.put("inputUser", UserUtil.getUser().getId().toString());
		workflowService.complete(leave.getClass().getSimpleName(), leave.getId(),variables,message);
		return "success";
	}
	
	@RequestMapping(value = "/toUpdate")
	public String update(String id,  String display,Model model) {
		Leave leave=leaveService.selectByPrimaryKey(id);
		String businessKey=	leave.getClass().getSimpleName()+"."+leave.getId();
		model.addAttribute("leave",leave);
		List<Map<String, Object>> commentList =null;
		if(display.equals("yes")){
			commentList = workflowService.findCommentByBusinessKey(businessKey);
			return "activiti/leave/update";
		}else{
			model.addAttribute("commentList",commentList);
			return "activiti/leave/history";
		}
	
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(@ModelAttribute @RequestBody Leave leave,Model model,String buttonValue,String message) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("message", buttonValue);
		variables.put("inputUser", UserUtil.getUser().getId().toString());
		workflowService.complete(leave.getClass().getSimpleName(), leave.getId(),variables,message);
		return "success";
	}


	

}
