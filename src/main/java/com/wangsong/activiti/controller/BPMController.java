package com.wangsong.activiti.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.activiti.service.BPMService;
import com.wangsong.activiti.service.ProcessDefinitionService;
import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.Page;
import com.wangsong.common.util.UserUtil;
import com.wangsong.system.model.User;

/**
 * 字典controller
 * @author ty
 * @date 2015年1月13日
 */
@Controller
@RequestMapping("activiti/bpm")
public class BPMController extends BaseController{
	
	
	@Autowired
	private BPMService bpmService;
	@Autowired
	private ProcessDefinitionService processDefinitionService;
	/**
	 * 默认页面
	 */
	@RequestMapping(value="/toList")
	public String list() {
		return "activiti/bpm/list";
	}
	
	/**
	 * 获取字典json
	 */
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Map<String, Object> dictList(HttpServletRequest request) {
		Page<Map<String, Object>> page = getPage(request);
		page= bpmService.findTaskListByUserId(page,((User)UserUtil.getUser()).getId().toString());
		return getEasyUIData(page);
	}
	
	@RequestMapping(value="/commentList")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request,String businessKey) {
		Page<Map<String, Object>> page = getPage(request);
		List<Map<String, Object>> commentList =bpmService.findCommentByBusinessKey(businessKey);
		page.setResult(commentList); 
		page.setTotalCount(commentList.size());
		return getEasyUIData(page);
	}
	
	/**
	 * 修改字典跳转
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/toUpdate")
	public String updateForm(String id) {
		String url = bpmService.findTaskFormKeyByTaskId(id);
		String sid = bpmService.findIdByTaskId(id);
		return "redirect:"+url+"?id="+sid+"&display=yes";
	}
	
	@RequestMapping(value = "/toViewImage")
	public String toViewImage(String taskId,Model model) {
		ProcessDefinition pd = bpmService.findProcessDefinitionByTaskId(taskId);
		model.addAttribute("deploymentId", pd.getDeploymentId());
		model.addAttribute("diagramResourceName",pd.getDiagramResourceName());
		Map<String, Object> map = bpmService.findCoordingByTaskId(taskId);
		model.addAttribute("acs", map);
		return "activiti/bpm/viewImage";
	}
	
	
	@RequestMapping(value="/viewImage")
	public void viewImage(String deploymentId,String diagramResourceName,HttpServletResponse response) throws Exception{
	
		//2：获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
		InputStream in = processDefinitionService.findImageInputStream(deploymentId,diagramResourceName);
		//3：从response对象获取输出流
		OutputStream out = response.getOutputStream();
		//4：将输入流中的数据读取出来，写到输出流中
		for(int b=-1;(b=in.read())!=-1;){
			out.write(b);
		}
		out.close();
		in.close();
		//将图写到页面上，用输出流写
	}
}
