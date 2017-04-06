package com.wangsong.system.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.common.service.impl.BaseServiceImpl;
import com.wangsong.system.dao.RoleMapper;
import com.wangsong.system.dao.RoleResourcesMapper;
import com.wangsong.system.dao.UserRoleMapper;
import com.wangsong.system.model.Role;
import com.wangsong.system.model.RoleResources;
import com.wangsong.system.model.UserRole;
import com.wangsong.system.service.RoleService;


@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RoleResourcesMapper roleResourcesMapper;
	

	@Override
	public int insertRole(Role role) {
		
		int j=insert(role);
		
		if(role.getResourcesId()!=null){
			for(int i=0;i<role.getResourcesId().length;i++){
				RoleResources roleResources=new RoleResources();
				roleResources.setId(UUID.randomUUID().toString());
				roleResources.setResourcesId(role.getResourcesId()[i]);
				roleResources.setRoleId(role.getId());
				roleResourcesMapper.insert(roleResources);
			}
		}
		
		return j;
	}

	@Override
	public int updateRole(Role role) {
		RoleResources roleResources2=new RoleResources();
		roleResources2.setRoleId(role.getId());
		roleResourcesMapper.deleteByT(new RoleResources[]{roleResources2});
		if(role.getResourcesId()!=null){
			for(int i=0;i<role.getResourcesId().length;i++){
				RoleResources roleResources=new RoleResources();
				roleResources.setId(UUID.randomUUID().toString());
				roleResources.setRoleId(role.getId());
				roleResources.setResourcesId(role.getResourcesId()[i]);
				roleResourcesMapper.insert(roleResources);
			}
		}
		return roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public int deleteRole(String[] id) {
		RoleResources[] r=new RoleResources[id.length];
		UserRole[] u=new UserRole[id.length];
		for(int i=0;i<id.length;i++){
			RoleResources roleResources=new RoleResources();
			UserRole userRole=new UserRole();
			roleResources.setRoleId(id[i]);
			userRole.setRoleId(id[i]);
			r[i]=roleResources;
			u[i]=userRole;
		}

		userRoleMapper.deleteByT(u);
		roleResourcesMapper.deleteByT(r);
		return roleMapper.deleteByPrimaryKey(id);
	}



	@Override
	public List<RoleResources> findRoleResourcesByRole(Role role) {
		RoleResources roleResources=new RoleResources();
		roleResources.setRoleId(role.getId());
		return roleResourcesMapper.findTByT(roleResources);
	}
	@Override
	public Role selectByPrimaryKey(String id){
		Role role =roleMapper.selectByPrimaryKey(id);
		role.setResourcesId(new String[0]);
		return role;
		
	}
}
