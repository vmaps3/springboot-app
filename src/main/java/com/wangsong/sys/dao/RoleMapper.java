package com.wangsong.sys.dao;

import java.util.List;

import com.wangsong.sys.model.Role;
import com.wangsong.sys.util.Page;

public interface RoleMapper extends BaseMapper<Role>{

	int findRoleCountByRole(Role role);

	List<Role> findRoleByPage(Page<Role> role);
}