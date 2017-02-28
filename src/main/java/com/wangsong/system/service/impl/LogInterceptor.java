package com.wangsong.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.wangsong.system.model.Log;
import com.wangsong.system.model.User;
import com.wangsong.system.service.LogService;

public class LogInterceptor implements HandlerInterceptor {

	@Autowired
	private LogService logService;
	
	
	
	private Date beginTime;// 1、开始时间
	private Date endTime;// 2、结束时间

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		beginTime = new Date();
		return true;
	}

	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		endTime = new Date();
		
		Log log=new Log();
		String url =request.getRequestURL().toString();
		log.setUrl(url);
		Map map2=request.getParameterMap();
		Map<String, Object> map=new HashMap<>();
		map.putAll(map2);
		if(url.endsWith("login.do")){
			map.put("password","******");
		}
		log.setParameter(JSONObject.toJSONString(map));
		log.setRemoteAddr(request.getRemoteAddr());
		log.setAgent(request.getHeader("user-agent"));
		log.setBeginTime(beginTime);
		log.setEndTime(endTime);
		log.setUser((User) SecurityUtils.getSubject().getPrincipal());
		logService.insert(log);
	}

}

