package com.wangsong.sys.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.wangsong.sys.dao.UserMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import com.wangsong.sys.util.Page;


@Service("muserService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserServiceI{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	
	@Override
	public Page selectAll(Page page) {	
		 PageHelper.startPage(page.getPageNo(), page.getPageSize());
		 List<User> userList=userMapper.selectAll();
		 page.setResult(userList);
		 int  count=userMapper.selectAllCount();
		 page.setTotalCount(count);
		 return page;
	}
	
	@Override
	public List<UserRole> selectUserRoleAll(User user) {	
		
		List<UserRole> userRoleList= userRoleMapper.selectByUser(user);
		
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
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
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
		User user=new User();
		user.setId(id);
		userRoleMapper.deleteByUser(user);
		return userMapper.deleteByPrimaryKey(id);
	}

	
	@Override
	public User findUserByLoginName(String username) {
		return userMapper.findUserByLoginName(username);
	}

}
