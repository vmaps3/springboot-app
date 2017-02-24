package com.wangsong.system.controller;



import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.common.controller.BaseController;
import com.wangsong.system.model.Resources;
import com.wangsong.system.service.ResourcesService;



@Controller
@RequestMapping("/system/resources")
public class ResourcesController extends BaseController {
	@Autowired
	private ResourcesService resourcesService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "system/resources/list";
	}
	
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd(String pid) {
		ModelAndView mav= new ModelAndView("system/resources/add");
		mav.addObject("pid", pid);
		return mav;
	}
	
	@RequiresPermissions("/system/resources/add")
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(@Valid Resources resources, BindingResult result) {
			
		Map<String, Object>	map=new HashMap<>();
		if (!result.hasErrors()) {
			resourcesService.insertResources(resources);
			map.put("result", "success");	
		}else{
			map.put("result","error");
			map.put("msg", resultToList(result));
		}
		return map;
	}
	
	@RequiresPermissions("/system/resources/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String[] id) {
		Map<String, Object>	map=new HashMap<>();
		resourcesService.deleteResources(id);
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView mav= new ModelAndView("system/resources/update");
		mav.addObject("id", id);
		return mav;
	}
	
	@RequiresPermissions("/system/resources/update")
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(@Valid Resources resources, BindingResult result) {
		Map<String, Object>	map=new HashMap<>();
		if (!result.hasErrors()) {
			resourcesService.updateResources(resources);
			map.put("result", "success");
		}else{
			map.put("result","error");
			map.put("msg", resultToList(result));
		}
		return map;
	}
	
	@RequiresPermissions("/system/resources/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list() {
		return resourcesService.findResources();
	}
	

	@RequestMapping(value="/findResourcesEMUByResources")
	@ResponseBody
	public Object findResourcesEMUByResources() {
		
		return resourcesService.findResourcesEMUByResources();
	}
	
	@RequestMapping(value="/selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String id) {
		return resourcesService.selectByPrimaryKey(id);
	}
	
}
