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
import com.wangsong.sys.service.RoleServiceI;
import com.wangsong.sys.util.BaseController;
import com.wangsong.sys.util.Page;



@Controller
@RequestMapping("/sys/role")
public class RoleController  extends BaseController{
	@Autowired
	private RoleServiceI roleService;
	@Autowired
	private ResourcesServiceI resourcesService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/role/list";
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request) {
		Page page = getPage(request);
		page = roleService.selectAll(page);
		return getEasyUIData(page);
	}
	
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd() {
		ModelAndView mav= new ModelAndView("sys/role/add");
		return mav;
	}
	
	@RequestMapping(value="/add")
	public String add(Role role,String[] resourcesId) {
		roleService.insert(role,resourcesId);
		return "redirect:/sys/role/toList.do";
	}
	
	@RequestMapping(value="/delete")
	public String delete(String id) {
		
		roleService.delete(id);
		return "redirect:/sys/role/toList.do";
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView mav= new ModelAndView("sys/role/update");
		Role mrole = roleService.selectByPrimaryKey(id);
		mav.addObject("role", mrole);
		mav.addObject("list", roleService.selectRoleResourcesAll(mrole));
		return mav;
	}

	@RequestMapping(value="/update")
	public String update(Role mrole,String[] resourcesId) {
		
		roleService.update(mrole,resourcesId);
		return "redirect:/sys/role/toList.do";
	}
}
