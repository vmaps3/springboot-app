package com.wangsong.system.controller;


import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.Result;
import com.wangsong.system.entity.Resources;
import com.wangsong.system.service.IResourcesService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wangsong.common.controller.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-19
 */
@RestController
@RequestMapping("/system/resources")
public class ResourcesController extends BaseController {
    @Autowired
    private IResourcesService resourcesService;

    @RequiresPermissions("/system/resources/add")
    @RequestMapping(value = "/add")
    public Result add(@ModelAttribute Resources resources) {
        resourcesService.insertResources(resources);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }


    @RequiresPermissions("/system/resources/delete")
    @RequestMapping(value = "/delete")
    public Result delete(Long id) {
        resourcesService.deleteResources(id);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

    @RequiresPermissions("/system/resources/update")
    @RequestMapping(value = "/update")
    public Result update(@ModelAttribute Resources resources) {
        resourcesService.updateResources(resources);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @RequiresPermissions("/system/resources/list")
    @RequestMapping(value = "/list")
    public Result list() {
        return new Result(CodeEnum.SUCCESS.getCode(), resourcesService.findResources());
    }

    @RequestMapping(value = "/findResourcesEMUByResources")
    public Result findResourcesEMUByResources() {
        Long username= (Long) SecurityUtils.getSubject().getPrincipal();
        return new Result(CodeEnum.SUCCESS.getCode(), resourcesService.findResourcesEMUByResources(username));
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public Result selectByPrimaryKey(Long id) {
        return new Result(CodeEnum.SUCCESS.getCode(), resourcesService.selectByPrimaryKey(id));
    }
}
