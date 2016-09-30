package com.wangsong.sys.controller;



import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.service.ResourcesServiceI;



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
	
	@RequiresPermissions("/sys/resources/add")
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(Resources resources) {
			
		Map<String, Object>	map=new HashMap<>();
		resourcesService.insert(resources);
		return map;
	}
	
	@RequiresPermissions("/sys/resources/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String id) {
		Map<String, Object>	map=new HashMap<>();
		resourcesService.delete(id);
		return map;
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id,String pid) {
		ModelAndView mav= new ModelAndView("sys/resources/update");
		Resources mresources = resourcesService.selectByPrimaryKey(id);
		mav.addObject("resources", mresources);
		mav.addObject("pid", pid);
		return mav;
	}
	
	@RequiresPermissions("/sys/resources/update")
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(Resources mresources) {
		Map<String, Object>	map=new HashMap<>();
		resourcesService.updateByPrimaryKey(mresources);
		return map;
	}
	
	@RequiresPermissions("/sys/resources/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list() {
		return resourcesService.selectAllJson();
	}
	

	@RequestMapping(value="/findMapListByType")
	@ResponseBody
	public Object findMapListByType() {
		
		return resourcesService.findMapListByType();
	}
	
}
