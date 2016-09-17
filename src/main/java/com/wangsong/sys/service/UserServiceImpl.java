package com.wangsong.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.RoleMapper;
import com.wangsong.sys.dao.UserMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;


@Service("muserService")
@Transactional
public class UserServiceImpl implements UserServiceI{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RoleServiceI roleService;
	@Override
	public List<User> selectAll() {	
		return userMapper.selectAll();
	}
	
	@Override
	public List<Map<String, Object>> selectUserRoleAll(User user) {	
		List<Role> roleList=roleService.selectAll();
		List<UserRole> userRoleList= userRoleMapper.selectByUser(user);
		List<Map<String,Object>> mapList=new ArrayList<>();
		for(int i=0;i<roleList.size();i++){
			Map<String,Object> map=new HashMap<>();
			Role role=roleList.get(i);
			map.put("id", role.getId());
			map.put("name",role.getName());
			boolean selected=false;
			for(int j=0;j<userRoleList.size();j++){
				UserRole  userRole =userRoleList.get(j);
				if(userRole.getRoleId().equals(role.getId())){
					selected=true;
				}
			}
			map.put("selected",selected);
			mapList.add(map);
		}
		return mapList;
	}

	@Override
	public int insert(User user,String[] roleId) {
		String id = UUID.randomUUID().toString();
		user.setId(id);
		for(int i=0;i<roleId.length;i++){
			UserRole userRole=new UserRole();
			userRole.setId(UUID.randomUUID().toString());
			userRole.setUserId(id);
			userRole.setRoleId(roleId[i]);
			userRoleMapper.insert(userRole);
		}
		
		return userMapper.insert(user);
	}

	@Override
	public int update(User user,String[] roleId) {
		userRoleMapper.deleteByUser(user);
		if(roleId!=null){
			for(int i=0;i<roleId.length;i++){
				UserRole userRole=new UserRole();
				userRole.setId(UUID.randomUUID().toString());
				userRole.setUserId(user.getId());
				userRole.setRoleId(roleId[i]);
				userRoleMapper.insert(userRole);
			}
		}
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int delete(String id) {
	
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User selectByPrimaryKey(String id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

}
