package com.wangsong.system.service.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.util.JWTToken;
import com.wangsong.system.entity.User;
import com.wangsong.system.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public String loginPost(User user) throws UnsupportedEncodingException {


        String md5Hex = DigestUtils.md5Hex(user.getPassword());

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), md5Hex);

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        Date date = new Date(System.currentTimeMillis() + 1800000);

        Algorithm algorithm = Algorithm.HMAC256(md5Hex);
        // 附带username信息
        String sign = JWT.create()
                .withClaim("username", user.getUsername())
                .withExpiresAt(date)
                .sign(algorithm);
        return sign;


    }


    @Override
    public void logoutJSON() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @Override
    public String getStatus(HttpServletRequest request) {
        return request.getAttribute("javax.servlet.error.status_code").toString();
    }

}


