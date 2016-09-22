package com.wangsong.sys.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.RoleServiceI;
import com.wangsong.sys.service.UserServiceI;
import com.wangsong.sys.util.BaseController;
import com.wangsong.sys.util.Page;

@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController{
	@Autowired
	private UserServiceI userService;
	@Autowired
	private RoleServiceI roleService;

//	@RequestMapping(value="/list")
//	public String list(HttpServletRequest request) {
//		List <User> list = userService.selectAll();
//		request.setAttribute("list", list);
//		return "sys/user/list";
//	}
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/user/list";
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request) {
		Page<User> page = getPage(request);
		page = userService.selectAll(page);
		return getEasyUIData(page);
	}
	
	
	@RequiresPermissions("/sys/user/toAdd")
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd() {
		ModelAndView mav= new ModelAndView("sys/user/add");
		mav.addObject("list", roleService.selectAll());
		return mav;
	}
	
	@RequestMapping(value="/add")
	public String add(User user,String[] roleId) {
		userService.insert(user,roleId);
		return "redirect:/sys/user/toList.do";
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		User muser = userService.selectByPrimaryKey(id);
		ModelAndView mav= new ModelAndView("sys/user/update");
		mav.addObject("user", muser);
		mav.addObject("list", userService.selectUserRoleAll(muser));
		return mav;
	}

	@RequestMapping(value="/update")
	public String update(User muser,String[] roleId) {
		userService.update(muser,roleId);
		return "redirect:/sys/user/toList.do";
	}
	
	@RequestMapping(value="/delete")
	public String delete(String id) {
		userService.delete(id);
		return "redirect:/sys/user/toList.do";
	}
}
