package com.wangsong.system.controller;


import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.common.model.Result;
import com.wangsong.system.entity.Role;
import com.wangsong.system.service.IRoleService;
import com.wangsong.system.vo.RoleAddModel;
import com.wangsong.system.vo.RolePage;
import com.wangsong.system.vo.RoleVO;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wangsong.common.controller.BaseController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-19
 */
@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController {
    @Autowired
    private IRoleService roleService;

    @RequiresPermissions("/system/role/list")
    @RequestMapping(value = "/list")
    public Result list(@ModelAttribute RolePage role) {
        GetEasyUIData tByPage = roleService.findTByPage(role);
        return new Result(CodeEnum.SUCCESS.getCode(), tByPage);
    }

    @RequiresPermissions("/system/role/add")
    @RequestMapping(value = "/add")
    public Result add(@ModelAttribute RoleAddModel role) {
        roleService.insertRole(role);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }


    @RequiresPermissions("/system/role/delete")
    @RequestMapping(value = "/delete")
    public Result delete(Long[]id) {
        roleService.deleteRole(id);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

    @RequiresPermissions("/system/role/update")
    @RequestMapping(value = "/update")
    public Result update(@ModelAttribute RoleAddModel mrole) {
        roleService.updateRole(mrole);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

    @RequestMapping(value = "/listAll")
    public Result listAll() {
        List<Role> roles = roleService.list();
        return new Result(CodeEnum.SUCCESS.getCode(), roles);
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public Result selectByPrimaryKey(Long id) {
        RoleVO roleVO = roleService.selectByPrimaryKey(id);
        return new Result(CodeEnum.SUCCESS.getCode(), roleVO);
    }

}
