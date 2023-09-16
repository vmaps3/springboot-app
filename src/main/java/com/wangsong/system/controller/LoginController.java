package com.wangsong.system.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.Result;
import com.wangsong.system.entity.User;
import com.wangsong.system.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Api(value = "登录相关")
@Controller
@ControllerAdvice
public class LoginController extends BaseController implements ErrorController {

    private final static String ERROR_PATH = "/error";


    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "默认页", httpMethod = "POST")
    @RequestMapping(value = "/index")
    @ResponseBody
    public Result index() {
        return new Result(CodeEnum.INDEX.getCode(), null);
    }


    @ApiOperation(value = "登录", httpMethod = "POST")
    @RequestMapping(value = "/login")
    @ResponseBody
    public Result loginPost(@ModelAttribute User user) throws UnsupportedEncodingException {
        String data = loginService.loginPost(user);
        return new Result(CodeEnum.SUCCESS.getCode(), data);
    }

    @ApiOperation(value = "退出", httpMethod = "POST")
    @RequestMapping(value = "/logoutJSON")
    @ResponseBody
    public Result logoutJSON() {
        loginService.logoutJSON();
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "容器错误页", httpMethod = "POST")
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public Result getStatus(HttpServletRequest request) {
        return new Result(loginService.getStatus(request), null);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public Result illegalArgumentException(IllegalArgumentException e) {
        return new Result(e.getMessage(), null);
    }

}
