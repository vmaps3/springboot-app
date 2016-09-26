package com.wangsong.sys.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.ResourcesServiceI;
import com.wangsong.sys.util.BaseController;
import com.wangsong.sys.util.Page;



@Controller
@RequestMapping("/sys/resources")
public class ResourcesController extends BaseController {
	@Autowired
	private ResourcesServiceI resourcesService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/resources/list";
	}
	
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd(String pid) {
		ModelAndView mav= new ModelAndView("sys/resources/add");
		mav.addObject("pid", pid);
		mav.addObject("list", resourcesService.selectAll());
		return mav;
	}
	
	@RequestMapping(value="/add")
	public String add(Resources resources) {
			
		
		resourcesService.insert(resources);
		return "redirect:/sys/resources/toList.do";
	}
	
	@RequestMapping(value="/delete")
	public String delete(String id) {
		
		resourcesService.deleteByPrimaryKey(id);
		return "redirect:/sys/resources/toList.do";
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id,String pid) {
		ModelAndView mav= new ModelAndView("sys/resources/update");
		Resources mresources = resourcesService.selectByPrimaryKey(id);
		mav.addObject("resources", mresources);
		mav.addObject("pid", pid);
		return mav;
	}

	@RequestMapping(value="/update")
	public String update(Resources mresources) {
		
		resourcesService.updateByPrimaryKey(mresources);
		return "redirect:/sys/resources/toList.do";
	}
	
	@RequestMapping(value="/findResourceListByType")
	@ResponseBody
	public Object findResourceListByType() {
		
		return resourcesService.findResourceListByType();
	}
	

	@RequestMapping(value="/findMapListByType")
	@ResponseBody
	public Object findMapListByType() {
		
		return resourcesService.findMapListByType();
	}
	
}
