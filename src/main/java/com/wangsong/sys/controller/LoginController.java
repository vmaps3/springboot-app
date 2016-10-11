package com.wangsong.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LoginController  extends BaseController {
	
	@RequestMapping(value = "/")
    public String index() {
        return "index";
    }

  
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login() {
      
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

  
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Object loginPost(String username, String password) {
    	Subject user = SecurityUtils.getSubject();
    	UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password).toCharArray());
    	Map<String, Object>	map=new HashMap<>();
        try {
            user.login(token);
        } catch (UnknownAccountException e) {
        	map.put("msg", "账号不存在");
        } catch (DisabledAccountException e) {
        	map.put("msg", "账号未启用");
        } catch (IncorrectCredentialsException e) {
        	map.put("msg", "密码错误");
        } catch (RuntimeException e) {
        	e.printStackTrace();
        	map.put("msg", "未知错误,请联系管理员");
        }
        return map;
    }

    @RequestMapping(value = "/logout.do")
    public String logout() {
    	Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
