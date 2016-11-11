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
import com.wangsong.sys.model.Dict;
import com.wangsong.sys.service.DictService;

@Controller
@RequestMapping("/haha")
public class HahaController extends BaseController{
	
	
	@RequestMapping(value="/haha")
	@ResponseBody
	public Object haha(String username) {
		Map<String,Object> map=new HashMap<>();
		if("123123".equals(username)){
			map.put("key", "1");
		}else{
			map.put("key", "0");
		}
		return map;
	}
	
	
	
}
