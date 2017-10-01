package com.wangsong.customer.service.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.wangsong.common.util.ShiroUtil;
import com.wangsong.customer.model.CustomerUser;
import com.wangsong.customer.model.Regist;
import com.wangsong.customer.service.CustomerUserService;

public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	private CustomerUserService customerUserService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		CustomerUser user = customerUserService.findTByRegist(new Regist(token.getUsername(),null,null));
		//判断用户必须存在,空指针异常
		//密码必须相等,考虑B用户登录密码错误,删除SessionId
		if(user!=null&&user.getPassword().equals(new String (token.getPassword()))){
			ShiroUtil.deleteSession(user.getId());
		}
		// 认证缓存信息
		return new SimpleAuthenticationInfo(user.getId(), user.getPassword().toCharArray(), getName());
	}

	/**
	 * 
	 * Shiro权限认证
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return new SimpleAuthorizationInfo();
	}

}
