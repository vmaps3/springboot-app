package com.wangsong.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.Result;
import com.wangsong.customer.model.CustomerUser;
import com.wangsong.customer.model.Regist;
import com.wangsong.customer.model.UpPassword;
import com.wangsong.customer.service.CustomerUserService;
import com.wangsong.util.service.UtilService;



@Controller
@RequestMapping("/customer/customer_user")
public class CustomerUserController  extends BaseController {
	
	@Autowired
	private CustomerUserService customerUserService;
	@Autowired
	private UtilService utilService;
  

	@RequestMapping(value="/shiroSessionId")
	@ResponseBody
	public Result getSessionId() {
		return customerUserService.getSessionId();
	}
	@RequestMapping(value="/regist")
	@ResponseBody
	public Object regist(Regist regist,HttpServletRequest request) {
		return customerUserService.regist(regist,request);
	}
	
	@RequestMapping(value="/getIMGValidateCode")
    public void getIMGValidateCode(HttpServletRequest request,HttpServletResponse response) throws Exception{  
		utilService.getIMGValidateCode(request,response);
    } 
	
	@RequestMapping(value="/getSMSValidateCodeRegist")
	@ResponseBody
	public Object getSMSVerificationCodeRegist(HttpServletRequest request,Regist regist) {
		return customerUserService.getSMSVerificationCodeRegist(request,regist);		
	}
	@RequestMapping(value="/signoff")
	@ResponseBody
	public Object signoff() {
		return customerUserService.signoff();
	}
	@RequestMapping(value="/login")
	@ResponseBody
	public Object login(Regist regist) {
		return customerUserService.login(regist);
	}
	@RequestMapping(value="/index")
	@ResponseBody
	public Object index() throws Exception {
		return customerUserService.index();
	}
	 @RequestMapping(value="/getSMSValidateCodeForgetPassword")
	 @ResponseBody
	 public Object getSMSValidateCodeForgetPassword(HttpServletRequest request,Regist regist) {
		 return customerUserService.getSMSValidateCodeForgetPassword(regist,request);
	 }
	    
    @RequestMapping(value="/forgetPassword")  
    @ResponseBody
    public Object forgetPassword(HttpServletRequest request,Regist regist) {  
    	return customerUserService.forgetPassword(request,regist);
    } 
    @RequestMapping(value="/systemError")
	@ResponseBody
	public Object systemError() {
    	return customerUserService.systemError();
	}
	
	@RequestMapping(value="/notFound")
	@ResponseBody
	public Object notFound() {
		return customerUserService.notFound();
	}
	
	@RequestMapping(value="/unauth")
	@ResponseBody
	public Object unauth() {
		return customerUserService.unauth();
	}
	@RequestMapping(value="/saveUserInfo")
	@ResponseBody
	public Object userInfo(CustomerUser customerUser) {
		return customerUserService.insertUserInfo(customerUser);
	}
	@RequestMapping(value="/upPassword")
	@ResponseBody
	public Object upPassword(UpPassword upPassword) {
		return customerUserService.upPassword(upPassword);
	}
	@RequestMapping(value="/getAuthenticationState")
	@ResponseBody
	public Object getAuthenticationState() {
		return customerUserService.getAuthenticationState();
	}
}
