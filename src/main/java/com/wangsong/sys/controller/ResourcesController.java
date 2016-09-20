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
import com.wangsong.sys.service.ResourcesServiceI;



@Controller
@RequestMapping("/sys/resources")
public class ResourcesController {
	@Autowired
	private ResourcesServiceI resourcesService;

	@RequestMapping(value="/list")
	public String list(HttpServletRequest request) {
		
		List <Resources> list = resourcesService.selectAll();
		request.setAttribute("list", list);
		return "sys/resources/list";
	}
	
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd() {
		ModelAndView mav= new ModelAndView("sys/resources/add");
	
		mav.addObject("list", resourcesService.selectAll());
		return mav;
	}
	
	@RequestMapping(value="/add")
	public String add(Resources resources) {
			
		
		resourcesService.insert(resources);
		return "redirect:/sys/resources/list.do";
	}
	
	@RequestMapping(value="/delete")
	public String delete(String id) {
		
		resourcesService.delete(id);
		return "redirect:/sys/resources/list.do";
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView mav= new ModelAndView("sys/resources/update");
		Resources mresources = resourcesService.selectByPrimaryKey(id);
		mav.addObject("resources", mresources);
		mav.addObject("list", resourcesService.selectAll());
		return mav;
	}

	@RequestMapping(value="/update")
	public String update(Resources mresources) {
		
		resourcesService.update(mresources);
		return "redirect:/sys/resources/list.do";
	}
	
	@RequestMapping(value="/findResourceListByType")
	@ResponseBody
	public Object findResourceListByType(String pid) {
		
		return resourcesService.findResourceListByType(pid);
	}
	
}
