package com.wangsong.sys.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.sys.service.LogService;
import com.wangsong.sys.util.Page;

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
	public Object list(HttpServletRequest request) {
		Page page = getPage(request);
		page = logService.selectAll(page);
		return getEasyUIData(page);
	}

}