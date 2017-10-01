package com.wangsong.customer.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.common.controller.BaseController;
import com.wangsong.customer.model.UpTransactionPassword;
import com.wangsong.customer.service.CustomerAccountService;
import com.wangsong.util.service.UtilService;

@Controller
@RequestMapping("/customer/customer_account")
public class CustomerAccountController  extends BaseController {
	
	@Autowired
	private CustomerAccountService customerAccountService;
	
	@RequestMapping(value="/upTransactionPassword")
	@ResponseBody
	public Object upTransactionPassword(UpTransactionPassword upTransactionPassword,HttpServletRequest request) {
		return customerAccountService.upTransactionPassword(upTransactionPassword,request);
	}
	
	@RequestMapping(value="/saveTransactionPassword")
	@ResponseBody
	public Object saveTransactionPassword(UpTransactionPassword upTransactionPassword) {
		return customerAccountService.saveTransactionPassword(upTransactionPassword);
	}
	@RequestMapping(value="/getTransactionPasswordState")
	@ResponseBody
	public Object getTransactionPasswordState() {
		return customerAccountService.getTransactionPasswordState();
		
	}
}