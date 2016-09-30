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
	
	@RequiresPermissions("/sys/user/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request) {
		Page page = getPage(request);
		page = userService.selectAll(page);
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
		User muser = userService.selectByPrimaryKey(id);
		ModelAndView mav= new ModelAndView("sys/user/update");
		mav.addObject("user", muser);
		mav.addObject("list", userService.selectUserRoleAll(muser));
		return mav;
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
	public Object delete(String id) {
		Map<String, Object>	map=new HashMap<>();
		userService.delete(id);
		return map;
	}
	
	@RequestMapping(value="/findUserByLoginName")
	@ResponseBody
	public Object findUserByLoginName(String username) {
		return userService.findUserByLoginName(username);
	}
}
