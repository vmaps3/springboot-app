package com.wangsong.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.Page;
import com.wangsong.system.model.Dict;
import com.wangsong.system.service.DictService;

@Controller
@RequestMapping("/system/dict")
public class DictController extends BaseController{
	@Autowired
	private DictService dictService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "system/dict/list";
	}
	
	@RequiresPermissions("/system/dict/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request,Dict dict) {
		Page<Dict> page = getPage(request);
		page = dictService.findTByPage(page,dict);
		return getEasyUIData(page);
	}

	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "system/dict/add";
	}
	
	@RequiresPermissions("/system/dict/add")
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(@Valid Dict dict, BindingResult result) {
		Map<String, Object>	map=new HashMap<>();
		if (!result.hasErrors()) {
			dictService.insert(dict);
			map.put("result", "success");
		}else{
			map.put("result","error");
			map.put("msg", resultToList(result));
		}
		
		return map;
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView mav= new ModelAndView("system/dict/update");
		mav.addObject("id", id);
		return mav;
	}

	@RequiresPermissions("/system/dict/update")
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(@Valid Dict dict, BindingResult result) {
		Map<String, Object>	map=new HashMap<>();
		if (!result.hasErrors()) {
			dictService.updateByPrimaryKey(dict);
			map.put("result", "success");
		}else{
			map.put("result","error");
			map.put("msg", resultToList(result));
		}
		return map;
	}
	
	@RequiresPermissions("/system/dict/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String[] id) {
		Map<String, Object>	map=new HashMap<>();
		dictService.deleteByPrimaryKey(id);
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping(value="/findDictByDict")
	@ResponseBody
	public Object findDictByDict(Dict dict) {
		return dictService.findTByT(dict);
	}
	
	
	@RequestMapping(value="/selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String id) {
		return dictService.selectByPrimaryKey(id);
	}
	
}
