package com.wangsong.sys.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.commons.controller.BaseController;
import com.wangsong.commons.util.Page;
import com.wangsong.sys.model.Log;
import com.wangsong.sys.service.LogService;

@Controller
@RequestMapping("/sys/log")
public class LogController extends BaseController{
	@Autowired
	private LogService logService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/log/list";
	}
	
	@RequiresPermissions("/sys/log/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request,Log log) {
		Page<Log> page = getPage(request);
		page = logService.findTByPage(page,log);
		return getEasyUIData(page);
	}

	@RequiresPermissions("/sys/log/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String[] id) {
		Map<String, Object>	map=new HashMap<>();
		logService.deleteByPrimaryKey(id);
		return map;
	}
}