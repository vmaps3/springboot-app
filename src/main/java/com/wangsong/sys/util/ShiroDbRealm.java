package com.wangsong.sys.util;

import org.apache.shiro.authc.*;

import org.apache.shiro.authz.AuthorizationInfo;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

import org.apache.shiro.realm.AuthorizingRealm;

import org.apache.shiro.subject.PrincipalCollection;

import org.springframework.beans.factory.annotation.Autowired;

import com.wangsong.sys.model.Resources;

import com.wangsong.sys.model.User;

import com.wangsong.sys.service.ResourcesService;

import com.wangsong.sys.service.UserService;

import java.util.HashSet;

import java.util.List;

import java.util.Set;

public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private ResourcesService resourcesService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = new User();
		user.setUsername(token.getUsername());
		user = userService.findUserByUser(user);
		// 认证缓存信息
		return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());
	}

	/**
	 * 
	 * Shiro权限认证
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User shiroUser = (User) principals.getPrimaryPrincipal();
		Resources resources = new Resources();
		resources.setId(shiroUser.getId());
		List<Resources> roleList = resourcesService.findResourcesShiroByResources(resources);
		Set<String> urlSet = new HashSet<String>();
		for (Resources roleId : roleList) {
			urlSet.add(roleId.getUrl());
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(urlSet);
		return info;
	}

}
