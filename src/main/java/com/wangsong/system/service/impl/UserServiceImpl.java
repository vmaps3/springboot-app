package com.wangsong.system.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.common.model.Result;
import com.wangsong.system.dao.UserMapper;
import com.wangsong.system.dao.UserRoleMapper;
import com.wangsong.system.model.User;
import com.wangsong.system.model.UserPage;
import com.wangsong.system.model.UserRole;
import com.wangsong.system.service.UserService;
import com.wangsong.system.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public Result insertUser(User user, String[] roleId) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		user.setId(UUID.randomUUID().toString());
		userMapper.insert(user);
		if(roleId==null){
			return new Result("success",null);
		}
		for(int i=0;i<roleId.length;i++){	
			userRoleMapper.insert(new UserRole(UUID.randomUUID().toString()
					,user.getId(),roleId[i]));
		}
		return new Result("success",null);
	}

	@Override
	public Result updateUser(User user, String[] roleId) {
		if(!"".equals(user.getPassword())){
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
			userMapper.updateByPrimaryKey(user);
		}
		userMapper.updateNoPasswordByPrimaryKey(user);
		
		userRoleMapper.deleteByT(new UserRole[]{new UserRole(null,user.getId(),null)});
		
		
		if(roleId==null){
			return new Result("success",null);
		}
		for(int i=0;i<roleId.length;i++){
			userRoleMapper.insert(new UserRole(UUID.randomUUID().toString()
					,user.getId(),roleId[i]));
		}
		return new Result("success",null);
	}

	@Override
	public Result deleteUser(String[] id) {
		UserRole[] u=new UserRole[id.length];
		for(int i=0;i<id.length;i++){
			u[i]=new UserRole(null,id[i],null);
		}
		userRoleMapper.deleteByT(u);
		userMapper.deleteBy(id);
		
		return new Result("success",null);
	}

	@Override
	public User selectByPrimaryKey(){
		User u=userMapper.selectByPrimaryKey((String)SecurityUtils.getSubject().getPrincipal());
		u.setPassword("");
		return u;
	}

	@Override
	public Result updatePassword(User user) {
		if(!"".equals(user.getPassword())){
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
			userMapper.updateByPrimaryKey(user);
		}
		userMapper.updateNoPasswordByPrimaryKey(user);
		return new Result("success",null);
	}

	@Override
	public Object findTByPage(UserPage user) {
		user.setFirst((user.getPage() - 1) * user.getRows());
		return new GetEasyUIData(userMapper.findTByPage(user)
				,userMapper.findTCountByT(user));
	}

	@Override
	public Result index() {
		return new Result("index",null);
	}

	@Override
	public Result logoutJSON() {
		Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Result("success",null);
	}

	@Override
	public Result unauth() {
		 return new Result("unauth",null);
	}

	@Override
	public Result loginPost(String username, String password) {
		Subject user = SecurityUtils.getSubject();
    	UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password).toCharArray());
        try {
            user.login(token);
        	return new Result("success",null);
        } catch (UnknownAccountException e) {
        	return new Result("1001",null);//账号不存在
        } catch (DisabledAccountException e) {
        	return new Result("1002",null);//账号未启用
        } catch (IncorrectCredentialsException e) {
        	return new Result("1003",null);//密码错误
        } catch (RuntimeException e) {
        	return new Result("1004",null);//未知错误,请联系管理员
        }
		
	}

	@Override
	public UserVO selectByPrimaryKey(String id) {
		UserVO u=userMapper.selectVOByPrimaryKey(id);
		u.setPassword("");
		u.setUserRoleList(userRoleMapper.findTByT(new UserRole(null,id,null)));
		return u;
	}

	

	@Override
	public User findTByT(User user) {
		return userMapper.findTByT(user);
	}
	
}
