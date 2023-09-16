package com.wangsong.system.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.system.entity.*;
import com.wangsong.system.mapper.UserMapper;
import com.wangsong.system.service.IResourcesService;
import com.wangsong.system.service.IRoleResourcesService;
import com.wangsong.system.service.IUserRoleService;
import com.wangsong.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangsong.system.vo.UserAddModel;
import com.wangsong.system.vo.UserPage;
import com.wangsong.system.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private IUserRoleService userRoleMapper;
    @Autowired
    private IResourcesService resourcesService;
    @Autowired
    private IRoleResourcesService roleResourcesService;

    @Override
    public GetEasyUIData list(UserPage user) {
        IPage<User> page = new Page<>(user.getPage(), user.getRows());
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StrUtil.isNotBlank(user.getUsername())) {
            queryWrapper.eq("username", user.getUsername());
        }
        IPage<User> page1 = page(page, queryWrapper);
        return new GetEasyUIData(page1.getRecords(), page1.getTotal());
    }

    @Override
    @Transactional
    public void add(UserAddModel user) {
        Long[] roleIds = user.getRoleId();
        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        save(user);
        if (roleIds == null) {
            return;
        }
        for (Long roleId : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(roleId);
            userRoleMapper.save(userRole);
        }
    }


    @Override
    @Transactional
    public void updateUser(UserAddModel user) {
        Assert.notNull(user.getId(), CodeEnum.NO_NULL.getCode());
        Long[] roleIds = user.getRoleId();
        if (StrUtil.isNotBlank(user.getPassword())) {
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        } else {
            user.setPassword(null);
        }
        updateById(user);
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("user_id", user.getId());
        userRoleMapper.remove(updateWrapper);


        if (roleIds == null) {
            return;
        }
        for (Long roleId : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(roleId);
            userRoleMapper.save(userRole);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long[] id) {
        for (Long ids : id) {
            UpdateWrapper deleteWrapper = new UpdateWrapper();
            deleteWrapper.eq("user_id", ids);
            userRoleMapper.remove(deleteWrapper);
            removeById(ids);
        }
    }


    @Override
    public void updatePassword(UserAddModel user) {
        if (StrUtil.isNotBlank(user.getPassword())) {
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        } else {
            user.setPassword(null);
        }
        updateById(user);
    }

    @Override
    public String findTByT(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", user.getUsername());
        User userOne = getOne(queryWrapper);
        String r = userOne == null ? CodeEnum.SUCCESS.getCode() : CodeEnum.NO_NULL.getCode();
        return r;
    }

    @Override
    public User findTByUsername(Long userDetails) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", userDetails);
        User userOne = getOne(queryWrapper);
        return userOne;
    }




    @Override
    public UserVO selectVOByPrimaryKey(Long id) {
        User u = getById(id);
        u.setPassword("");
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(u, userVO);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", id);
        List<UserRole> userRoleList = userRoleMapper.list(queryWrapper);
        userVO.setUserRoleList(userRoleList);
        return userVO;

    }
}
