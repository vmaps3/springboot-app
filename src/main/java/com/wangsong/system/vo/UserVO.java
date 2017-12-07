package com.wangsong.system.vo;

import java.util.List;

import com.wangsong.system.model.UserRole;

public class UserVO {
	private String id;
	private String username;
	private String Password;
	private List<UserRole> UserRoleList;
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public List<UserRole> getUserRoleList() {
		return UserRoleList;
	}
	public void setUserRoleList(List<UserRole> userRoleList) {
		UserRoleList = userRoleList;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
