package com.wangsong.common.config;

import com.wangsong.common.model.JWTToken;
import com.wangsong.common.util.JWTUtil;
import com.wangsong.system.model.Resources;
import com.wangsong.system.model.User;
import com.wangsong.system.service.ResourcesService;
import com.wangsong.system.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourcesService resourcesService;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        String token = (String) authcToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        User user = userService.findTByT(new User(null, username, null));
        try {
            if (!JWTUtil.verify(token, username, user.getPassword())) {
                throw new AuthenticationException("密码不对");
            }
        } catch (UnsupportedEncodingException e) {
            throw new AuthenticationException("密码不对");
        }
        // 认证缓存信息
        return new SimpleAuthenticationInfo(user.getId(), token, getName());
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String shiroUser =(String)principals.getPrimaryPrincipal();

        List<Resources> roleList = resourcesService.findTByT(new Resources(shiroUser, null, null, null, "2", null));
        Set<String> urlSet = new HashSet<String>();
        for (Resources roleId : roleList) {
            urlSet.add(roleId.getUrl());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(urlSet);
        return info;
    }

}
