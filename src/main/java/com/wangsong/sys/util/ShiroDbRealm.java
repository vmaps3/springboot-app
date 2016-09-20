package com.wangsong.sys.util;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.ResourcesServiceI;
import com.wangsong.sys.service.RoleServiceI;
import com.wangsong.sys.service.UserServiceI;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceI userService;
    @Autowired
    private RoleServiceI roleService;
    @Autowired
    private ResourcesServiceI resourcesService;

    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.findUserByLoginName(token.getUsername());
      
        // 认证缓存信息
        return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());

    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {

    	User shiroUser = (User) principals.getPrimaryPrincipal();
    	List<String> roleList = roleService.findRoleIdListByUserId(shiroUser.getId());

        Set<String> urlSet = new HashSet<String>();
        for (String roleId : roleList) {
            List<String> roleResourceList = resourcesService.findResourceListByRoleId(roleId);
            if (roleResourceList != null) {
                for (String map : roleResourceList) {
                	urlSet.add(map);
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(urlSet);
        return info;
    }
}