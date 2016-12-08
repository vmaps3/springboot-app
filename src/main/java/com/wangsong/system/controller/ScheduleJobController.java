package com.wangsong.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.system.model.ScheduleJob;
import com.wangsong.system.service.ScheduleJobService;


/**
 * 定时任务 controller
 * @author ty
 * @date 2015年1月14日
 */
@Controller
@RequestMapping("system/scheduleJob")
public class ScheduleJobController {
	
	@Autowired
	private ScheduleJobService scheduleJobService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "system/scheduleJob/list";
	}
	
	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "system/scheduleJob/add";
	}
	
	@RequestMapping(value="/cron")
	public String cron() {
		return "system/scheduleJob/cron";
	}
	
	
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(ScheduleJob scheduleJob) {
		ModelAndView mav= new ModelAndView("system/scheduleJob/update");
		mav.addObject("scheduleJob", scheduleJob);
		return mav;
	}
	
	/**
	 * 获取定时任务 json
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> getAllJobs(){
		List<ScheduleJob> scheduleJobs = scheduleJobService.getAllScheduleJob();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", scheduleJobs);
		map.put("total", scheduleJobs.size());
		return map;
	}
	
	
	/**
	 * 添加
	 * @param user
	 * @param model
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object create(ScheduleJob scheduleJob) {
		Map<String, Object>	map=new HashMap<>();
		scheduleJobService.add(scheduleJob);
		map.put("result", "success");	
		return map;
	}
	
	/**
	 * 暂停任务
	 */
	@RequestMapping("/stop")
	@ResponseBody
	public Object stop(String[] name,String[] group) {
		Map<String, Object>	map=new HashMap<>();
		scheduleJobService.stopJob(name,group);
		map.put("result", "success");	
		return map;
	}

	/**
	 * 删除任务
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(String[] name,String[] group) {
		Map<String, Object>	map=new HashMap<>();
		scheduleJobService.delJob(name,group);
		map.put("result", "success");	
		return map;
	}

	/**
	 * 修改表达式
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(ScheduleJob scheduleJob) {
		Map<String, Object>	map=new HashMap<>();
		//验证cron表达式
		if(CronExpression.isValidExpression(scheduleJob.getCronExpression())){
			scheduleJobService.modifyTrigger(scheduleJob);
			map.put("result", "success");	
		}else{
			map.put("result","error");
			map.put("msg","Cron表达式不正确");	
		}
		return map;
	}

	/**
	 * 立即运行一次
	 */
	@RequestMapping("/startNow")
	@ResponseBody
	public Object stratNow(String[] name,String[] group) {
		Map<String, Object>	map=new HashMap<>();
		scheduleJobService.startNowJob(name,group);
		map.put("result", "success");	
		return map;
	}

	/**
	 * 恢复
	 */
	@RequestMapping("/resume")
	@ResponseBody
	public Object resume(String[] name,String[] group) {
		Map<String, Object>	map=new HashMap<>();
		scheduleJobService.restartJob(name,group);
		map.put("result", "success");	
		return map;
	}

	
}
