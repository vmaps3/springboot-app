package com.wangsong.sys.dao;

import java.util.List;

import com.wangsong.sys.model.Role;

public interface RoleMapper extends BaseMapper<Role>{

	int findRoleCountByRole(Role role);

	List<Role> findRoleByRole(Role role);
}