package com.wangsong.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.sys.model.User;
import com.wangsong.sys.service.UserServiceI;
import com.wangsong.sys.util.Page;

@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController{
	@Autowired
	private UserServiceI userService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/user/list";
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request) {
		Page page = getPage(request);
		page = userService.selectAll(page);
		return getEasyUIData(page);
	}
	
	
	@RequiresPermissions("/sys/user/toAdd")
	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "sys/user/add";
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
	
	@RequestMapping(value="/findUserByLoginName")
	@ResponseBody
	public Object findUserByLoginName(String username) {
		return userService.findUserByLoginName(username);
	}
}
