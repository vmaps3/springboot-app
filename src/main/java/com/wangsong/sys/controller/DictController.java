package com.wangsong.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.sys.model.Dict;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.DictServiceI;
import com.wangsong.sys.service.UserServiceI;
import com.wangsong.sys.util.Page;

@Controller
@RequestMapping("/sys/dict")
public class DictController extends BaseController{
	@Autowired
	private DictServiceI dictService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/dict/list";
	}
	
	@RequiresPermissions("/sys/dict/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request) {
		Page page = getPage(request);
		page = dictService.selectAll(page);
		return getEasyUIData(page);
	}

	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "sys/dict/add";
	}
	
	@RequiresPermissions("/sys/dict/add")
	@RequestMapping(value="/add")
	public String add(Dict dict) {
		dictService.insert(dict);
		return "redirect:/sys/dict/toList.do";
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		Dict muser = dictService.selectByPrimaryKey(id);
		ModelAndView mav= new ModelAndView("sys/dict/update");
		mav.addObject("dict", muser);
		return mav;
	}

	@RequiresPermissions("/sys/dict/update")
	@RequestMapping(value="/update")
	public String update(Dict dict) {
		dictService.updateByPrimaryKey(dict);
		return "redirect:/sys/dict/toList.do";
	}
	
	@RequiresPermissions("/sys/dict/delete")
	@RequestMapping(value="/delete")
	public String delete(String id) {
		dictService.deleteByPrimaryKey(id);
		return "redirect:/sys/dict/toList.do";
	}
	
	@RequestMapping(value="/selectByDict")
	@ResponseBody
	public Object selectByDict(Dict dict) {
		return dictService.selectByDict(dict);
	}
	
}
