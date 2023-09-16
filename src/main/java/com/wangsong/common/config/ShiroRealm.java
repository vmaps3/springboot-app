package com.wangsong.common.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangsong.common.util.JWTToken;
import com.wangsong.system.entity.Resources;
import com.wangsong.system.entity.RoleResources;
import com.wangsong.system.entity.User;
import com.wangsong.system.entity.UserRole;
import com.wangsong.system.mapper.UserRoleMapper;
import com.wangsong.system.service.IResourcesService;
import com.wangsong.system.service.IRoleResourcesService;
import com.wangsong.system.service.IUserRoleService;
import com.wangsong.system.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IResourcesService resourcesService;
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IRoleResourcesService roleResourcesService;

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


        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getClaim("username").asString();

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        User user = userService.getOne(queryWrapper);
        try {
            String password = user.getPassword();
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            verifier.verify(token);
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
        // 认证缓存信息
        return new SimpleAuthenticationInfo(user.getId(), token, getName());
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = (Long) principals.getPrimaryPrincipal();


        List<Resources> resourcesList = resourcesService.findResourcesyUserId(userId);

        Set<String> urlSet = new HashSet<String>();
        for (Resources roleId : resourcesList) {
            urlSet.add(roleId.getUrl());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(urlSet);
        return info;
    }

}
