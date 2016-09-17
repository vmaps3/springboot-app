package com.wangsong.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangsong.sys.dao.ResourcesMapper;
import com.wangsong.sys.dao.RoleMapper;
import com.wangsong.sys.dao.RoleResourcesMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.model.UserRole;


@Service
public class RoleServiceImpl implements RoleServiceI{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RoleResourcesMapper roleResourcesMapper;
	@Autowired
	private ResourcesMapper resourcesMapper;
	
	@Override
	public List<Role> selectAll() {
		
		return roleMapper.selectAll();
	}

	@Override
	public int insert(Role role, String[] resourcesId) {
		String id = UUID.randomUUID().toString();
		role.setId(id);
		for(int i=0;i<resourcesId.length;i++){
			RoleResources roleResources=new RoleResources();
			roleResources.setId(UUID.randomUUID().toString());
			roleResources.setResourcesId(resourcesId[i]);
			roleResources.setRoleId(id);
			roleResourcesMapper.insert(roleResources);
		}
		return roleMapper.insert(role);
	}

	@Override
	public int update(Role role) {
		
		return roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public int delete(String id) {
		Role role=new Role();
		role.setId(id);
		userRoleMapper.deleteByRole(role);
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role selectByPrimaryKey(String id) {
		
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Map<String, Object>> selectRoleResourcesAll(Role mrole) {
		List<Resources> resourcesList=resourcesMapper.selectAll();
		List<RoleResources> userRoleList= roleResourcesMapper.selectByRole(mrole);
		List<Map<String,Object>> mapList=new ArrayList<>();
		for(int i=0;i<resourcesList.size();i++){
			Map<String,Object> map=new HashMap<>();
			Resources role=resourcesList.get(i);
			map.put("id", role.getId());
			map.put("name",role.getName());
			boolean selected=false;
			for(int j=0;j<userRoleList.size();j++){
				RoleResources  userRole =userRoleList.get(j);
				if(userRole.getResourcesId().equals(role.getId())){
					selected=true;
				}
			}
			map.put("selected",selected);
			mapList.add(map);
		}
		return mapList;
	}

}
