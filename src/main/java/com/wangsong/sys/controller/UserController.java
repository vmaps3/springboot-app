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

import com.wangsong.sys.model.User;
import com.wangsong.sys.service.UserService;
import com.wangsong.sys.util.Page;

@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/user/list";
	}
	
	@RequiresPermissions("/sys/user/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request,User user) {
		Page<User> page = getPage(request);
		page = userService.findTByPage(page,user);
		return getEasyUIData(page);
	}
	
	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "sys/user/add";
	}
	@RequiresPermissions("/sys/user/add")
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(User user,String[] roleId) {
		Map<String, Object>	map=new HashMap<>();
		userService.insert(user,roleId);
		return map;
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView mav= new ModelAndView("sys/user/update");
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping(value="/selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String id) {
		User muser = userService.selectByPrimaryKey(id);
		return muser;
	}
	
	@RequestMapping(value="/findUserRoleByUser")
	@ResponseBody
	public Object findUserRoleByUser(User user) {
		return userService.findUserRoleByUser(user);
	}
	
	@RequiresPermissions("/sys/user/update")
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(User muser,String[] roleId) {
		Map<String, Object>	map=new HashMap<>();
		userService.update(muser,roleId);
		return map;
	}
	
	@RequiresPermissions("/sys/user/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String[] id) {
		Map<String, Object>	map=new HashMap<>();
		userService.delete(id);
		return map;
	}
	
	@RequestMapping(value="/findUserByUser")
	@ResponseBody
	public Object findUserByLoginName(User user) {
		return userService.findUserByUser(user);
	}
}
