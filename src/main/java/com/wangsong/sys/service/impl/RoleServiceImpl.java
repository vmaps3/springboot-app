package com.wangsong.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.commons.service.impl.BaseServiceImpl;
import com.wangsong.sys.dao.RoleMapper;
import com.wangsong.sys.dao.RoleResourcesMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.model.UserRole;
import com.wangsong.sys.service.RoleService;


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
	public List<Role> selectAll() {
		
		return roleMapper.selectAll();
	}

	@Override
	public int insert(Role role, String[] resourcesId) {
		String id = UUID.randomUUID().toString();
		role.setId(id);
		if(resourcesId!=null){
			for(int i=0;i<resourcesId.length;i++){
				RoleResources roleResources=new RoleResources();
				roleResources.setId(UUID.randomUUID().toString());
				roleResources.setResourcesId(resourcesId[i]);
				roleResources.setRoleId(id);
				roleResourcesMapper.insert(roleResources);
			}
		}
		
		return roleMapper.insert(role);
	}

	@Override
	public int update(Role role,String[] resourcesId) {
		RoleResources roleResources2=new RoleResources();
		roleResources2.setRoleId(role.getId());
		roleResourcesMapper.deleteByT(new RoleResources[]{roleResources2});
		if(resourcesId!=null){
			for(int i=0;i<resourcesId.length;i++){
				RoleResources roleResources=new RoleResources();
				roleResources.setId(UUID.randomUUID().toString());
				roleResources.setRoleId(role.getId());
				roleResources.setResourcesId(resourcesId[i]);
				roleResourcesMapper.insert(roleResources);
			}
		}
		return roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public int delete(String[] id) {
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

}
