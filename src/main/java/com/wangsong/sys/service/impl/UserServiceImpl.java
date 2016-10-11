package com.wangsong.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.UserMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import com.wangsong.sys.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	
	
	
	@Override
	public List<UserRole> findUserRoleByUser(User user) {	
		
		List<UserRole> userRoleList= userRoleMapper.findUserRoleByUser(user);
		
		return userRoleList;
	}

	@Override
	public int insert(User user,String[] roleId) {
		String id = UUID.randomUUID().toString();
		user.setId(id);
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		if(roleId!=null){
			for(int i=0;i<roleId.length;i++){
				UserRole userRole=new UserRole();
				userRole.setId(UUID.randomUUID().toString());
				userRole.setUserId(id);
				userRole.setRoleId(roleId[i]);
				userRoleMapper.insert(userRole);
			}
		}
		return userMapper.insert(user);
	}

	@Override
	public int update(User user,String[] roleId) {
		if(!"".equals(user.getPassword())){
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		}
		
		userRoleMapper.deleteUserRoleByUser(new User[]{user});
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
	public int delete(String[] id) {
		User[] u=new User[id.length];
		for(int i=0;i<id.length;i++){
			User user=new User();
			user.setId(id[i]);
			u[i]=user;
		}
			userRoleMapper.deleteUserRoleByUser(u);
			userMapper.deleteByPrimaryKey(id);
		
		return 0;
	}

	
	@Override
	public User findUserByUser(User user) {
		
		return userMapper.findUserByUser(user);
	}
	@Override
	public User selectByPrimaryKey(String id){
		User u=userMapper.selectByPrimaryKey(id);
		u.setPassword("");
		return u;
	}
}
