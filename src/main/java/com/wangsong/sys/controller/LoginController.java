package com.wangsong.sys.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController  {
   
	
    @RequestMapping(value = "/index.do")
    public String index(Model model) {
        return "index";
    }

  
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login() {
      
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index.do";
        }
        return "login";
    }

  
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)

    public String loginPost(String username, String password) {
    	Subject user = SecurityUtils.getSubject();
    	UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password).toCharArray());

        try {
            user.login(token);
        } catch (Exception e) {
        	return "login";
        }
        return "index";
    }

  
    @RequestMapping(value = "/unauth.do")
    public String unauth() {
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return "redirect:/login.do";
        }
        return "unauth";
    }

  
    @RequestMapping(value = "/logout.do")
    public String logout() {
    	Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
