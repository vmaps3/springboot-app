package com.wangsong.sys.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangsong.sys.model.Log;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.LogServiceI;


/**
 * 日志拦截器
 * @author ty
 * @date 2015年1月14日
 */
public class LogInterceptor implements HandlerInterceptor {

	@Autowired
	private LogServiceI logService;
	
	
	
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
		log.setUrl(request.getRequestURL().toString());
		log.setParameter(JSONObject.toJSONString(request.getParameterMap()));
		log.setRemoteAddr(request.getRemoteAddr());
		log.setAgent(request.getHeader("user-agent"));
		log.setBeginTime(beginTime);
		log.setEndTime(endTime);
		User user=(User) SecurityUtils.getSubject().getPrincipal();
		if(user!=null){
			log.setUserId(user.getId());
		}
		
		logService.insert(log);
	}

}
