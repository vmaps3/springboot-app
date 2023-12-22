package com.wangsong.system.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.Result;
import com.wangsong.system.entity.User;
import com.wangsong.system.service.LoginService;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@RestController
@ControllerAdvice
public class LoginController extends BaseController implements ErrorController {

    private final static String ERROR_PATH = "/error";


    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/index")
    public Result index() {
        return new Result(CodeEnum.INDEX.getCode(), null);
    }


    @RequestMapping(value = "/login")
    public Result loginPost(@ModelAttribute User user) throws UnsupportedEncodingException {
        String data = loginService.loginPost(user);
        return new Result(CodeEnum.SUCCESS.getCode(), data);
    }


    @RequestMapping(value = "/logoutJSON")
    public Result logoutJSON() {
        loginService.logoutJSON();
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @RequestMapping(value = ERROR_PATH)
    public Result getStatus(HttpServletRequest request) {
        return new Result(CodeEnum.ERROR.getCode(), loginService.getStatus(request));
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @ExceptionHandler(value = Exception.class)
    public Result illegalArgumentException(Exception e) {
        return new Result(CodeEnum.ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = UnauthenticatedException.class)
    public Result unauthenticatedException(Exception e) {
        return new Result(CodeEnum.LOGIN_EXCEPTION.getCode(), "未登录");
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public Result unauthorizedException(Exception e) {
        return new Result(CodeEnum.UNAUTH.getCode(), "无权限");
    }
}
