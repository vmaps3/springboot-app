package com.wangsong.system.controller;


import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.common.model.Result;
import com.wangsong.system.entity.User;
import com.wangsong.system.service.IUserService;
import com.wangsong.system.vo.UserAddModel;
import com.wangsong.system.vo.UserPage;
import com.wangsong.system.vo.UserVO;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wangsong.common.controller.BaseController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-19
 */
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;


    @RequiresPermissions("/system/user/list")
    @RequestMapping(value = "/list")
    public Result list(@ModelAttribute UserPage user) {
        GetEasyUIData list = userService.list(user);
        return new Result(CodeEnum.SUCCESS.getCode(), list);
    }

    @RequiresPermissions("/system/user/add")
    @RequestMapping(value = "/add")
    public Result add(@ModelAttribute UserAddModel user) {
        userService.add(user);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public Result selectByPrimaryKey(Long id) {
        UserVO userVO = userService.selectVOByPrimaryKey(id);
        return new Result(CodeEnum.SUCCESS.getCode(), userVO);
    }

    @RequiresPermissions("/system/user/update")
    @RequestMapping(value = "/update")
    public Result update(@ModelAttribute UserAddModel muser) {
        userService.updateUser(muser);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }


    @RequiresPermissions("/system/user/delete")
    @RequestMapping(value = "/delete")
    public Result delete(Long[] id) {
        userService.deleteUser(id);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @RequestMapping(value = "/findUserByUser")
    public Result findUserByUser(@ModelAttribute User user) {
        String r = userService.findTByT(user);
        return new Result(r, null);

    }

    @RequestMapping(value = "/toUpdatePassword")
    public Result toUpdatePassword() {
        Long userDetails = (Long) SecurityUtils.getSubject().getPrincipal();
        User tByUsername = userService.findTByUsername(userDetails);
        return new Result(CodeEnum.SUCCESS.getCode(), tByUsername);
    }

    @RequestMapping(value = "/updatePassword")
    public Result updatePassword(@ModelAttribute UserAddModel muser) {
        userService.updatePassword(muser);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }
}
