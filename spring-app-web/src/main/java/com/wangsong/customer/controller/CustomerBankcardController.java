package com.wangsong.customer.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.common.controller.BaseController;
import com.wangsong.customer.model.DeleteBankcard;
import com.wangsong.customer.model.SaveBankcard;
import com.wangsong.customer.service.CustomerBankcardService;

@Controller
@RequestMapping("/customer/customer_bankcard")
public class CustomerBankcardController  extends BaseController {
	
	@Autowired
	private CustomerBankcardService customerBankcardService;
  

	@RequestMapping(value="/saveBankcard")
	@ResponseBody
	public Object saveBankcard(SaveBankcard saveBankcard,HttpServletRequest request) {
		return customerBankcardService.insertBankcard(saveBankcard,request);
	}
	@RequestMapping(value="/getSMSValidateCodeSaveBankcard")
   	@ResponseBody
   	public Object getSMSValidateCodeSaveBankcard(HttpServletRequest request,SaveBankcard saveBankcard) {
		return customerBankcardService.getSMSValidateCodeSaveBankcard(request,saveBankcard);
   	}
	@RequestMapping(value="/getBankcards")
	@ResponseBody
	public Object selectBankcards() {
		return customerBankcardService.selectBankcards();
	}
	@RequestMapping(value="/deleteBankcard")
	@ResponseBody
	public Object deleteBankcard(DeleteBankcard deleteBankcard) {
		return customerBankcardService.deleteBankcard(deleteBankcard);
	}
	@RequestMapping(value="/getBankcardState")
	@ResponseBody
	public Object getBankcardState() {
		return customerBankcardService.getBankcardState();
	}

}