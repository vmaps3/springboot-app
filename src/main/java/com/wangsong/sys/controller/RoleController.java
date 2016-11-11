package com.wangsong.sys.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.commons.controller.BaseController;
import com.wangsong.commons.util.Page;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.service.RoleService;



@Controller
@RequestMapping("/sys/role")
public class RoleController  extends BaseController{
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/role/list";
	}
	
	@RequiresPermissions("/sys/role/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request,Role role) {
		Page<Role> page = getPage(request);
		page = roleService.findTByPage(page,role);
		return getEasyUIData(page);
	}
	
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd() {
		ModelAndView mav= new ModelAndView("sys/role/add");
		return mav;
	}
	
	@RequiresPermissions("/sys/role/add")
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(Role role,String[] resourcesId) {
		Map<String, Object>	map=new HashMap<>();
		roleService.insert(role,resourcesId);
		return map;
	}
	
	@RequiresPermissions("/sys/role/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String[] id) {
		Map<String, Object>	map=new HashMap<>();
		roleService.delete(id);
		return map;
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView mav= new ModelAndView("sys/role/update");
		mav.addObject("id", id);
		return mav;
	}

	@RequiresPermissions("/sys/role/update")
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(Role mrole,String[] resourcesId) {
		Map<String, Object>	map=new HashMap<>();
		roleService.update(mrole,resourcesId);
		return map;
	}
	
	@RequestMapping(value="/listAll")
	@ResponseBody
	public Object listAll() {
		return roleService.selectAll();
	}
	
	@RequestMapping(value="/selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String id) {
		return roleService.selectByPrimaryKey(id);
	}
	
	@RequestMapping(value="/findRoleResourcesByRole")
	@ResponseBody
	public Object findRoleResourcesByRole(Role role) {
		return roleService.findRoleResourcesByRole(role);
	}
	
	
}
