package com.wangsong.commons.util;

import org.apache.shiro.SecurityUtils;

import com.wangsong.sys.model.User;





public class UserUtil {
	/**
	 * 获取当前用户对象shiro
	 * @return shirouser
	 */
	public static User getUser(){
		User user=(User) SecurityUtils.getSubject().getPrincipal();
		return user;
	}
	

}
 