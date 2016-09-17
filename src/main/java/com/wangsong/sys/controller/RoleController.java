package com.wangsong.sys.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.sys.model.Role;
import com.wangsong.sys.service.ResourcesServiceI;
import com.wangsong.sys.service.RoleServiceI;



@Controller
@RequestMapping("/sys/role")
public class RoleController {
	@Autowired
	private RoleServiceI roleService;
	@Autowired
	private ResourcesServiceI resourcesService;
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request) {
		
		List <Role> list = roleService.selectAll();
		request.setAttribute("list", list);
		return "sys/role/list";
	}
	
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd() {
		ModelAndView mav= new ModelAndView("sys/role/add");
		mav.addObject("list", resourcesService.selectAll());
		return mav;
	}
	
	@RequestMapping(value="/add")
	public String add(Role role,String[] resourcesId) {
			
		
		roleService.insert(role,resourcesId);
		return "redirect:/sys/role/list.do";
	}
	
	@RequestMapping(value="/delete")
	public String delete(String id) {
		
		roleService.delete(id);
		return "redirect:/sys/role/list.do";
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
	public String update(Role mrole) {
		
		roleService.update(mrole);
		return "redirect:/sys/role/list.do";
	}
}
