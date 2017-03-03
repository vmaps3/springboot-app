package com.wangsong.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.Page;
import com.wangsong.system.model.User;
import com.wangsong.system.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "system/user/list";
	}
	
	@RequiresPermissions("/system/user/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request,User user) {
		Page<User> page = getPage(request);
		page = userService.findTByPage(page,user);
		return getEasyUIData(page);
	}
	
	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "system/user/add";
	}
	@RequiresPermissions("/system/user/add")
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(@Valid User user,BindingResult result) {
		Map<String, Object>	map=new HashMap<>();
		if (!result.hasErrors()) {
			userService.insertUser(user);
			map.put("result", "success");
		}else{
			map.put("result","error");
			map.put("msg", resultToList(result));
		}
		return map;
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView mav= new ModelAndView("system/user/update");
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
	
	@RequiresPermissions("/system/user/update")
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(@Valid User muser, BindingResult result) {
		Map<String, Object>	map=new HashMap<>();
		if (!result.hasErrors()) {
			userService.updateUser(muser);
			map.put("result", "success");
		}else{
			map.put("result","error");
			map.put("msg", resultToList(result));
		}
		return map;
	}
	
	@RequiresPermissions("/system/user/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String[] id) {
		Map<String, Object>	map=new HashMap<>();
		userService.deleteUser(id);
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping(value="/findUserByUser")
	@ResponseBody
	public Object findUserByUser(User user) {
		return userService.findTByTOne(user);
	}
}
