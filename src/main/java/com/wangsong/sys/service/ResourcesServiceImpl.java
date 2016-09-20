package com.wangsong.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangsong.sys.dao.ResourcesMapper;
import com.wangsong.sys.dao.RoleMapper;
import com.wangsong.sys.dao.RoleResourcesMapper;
import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;


@Service
public class ResourcesServiceImpl implements ResourcesServiceI{
	@Autowired
	private ResourcesMapper resourcesMapper;
	
	@Autowired
	private RoleResourcesMapper roleResourcesMapper;
	
	
	
	@Override
	public List<Resources> selectAll() {
		
		return resourcesMapper.selectAll();
	}

	@Override
	public int insert(Resources resources) {
		String id = UUID.randomUUID().toString();
		resources.setId(id);
		return resourcesMapper.insert(resources);
	}

	@Override
	public int update(Resources role) {
		
		return resourcesMapper.updateByPrimaryKey(role);
	}

	@Override
	public int delete(String id) {
		Resources resources=new Resources();
		resources.setId(id);
		roleResourcesMapper.deleteByResources(resources);
		return resourcesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Resources selectByPrimaryKey(String id) {
		
		return resourcesMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Map<String, Object>> selectAll(Resources resources) {
		List<Resources> resourcesList=resourcesMapper.selectAll();
		List<Map<String,Object>> mapList=new ArrayList<>();
		for(int i=0;i<resourcesList.size();i++){
			Resources r=resourcesList.get(i);
			Map<String,Object> map=new HashMap<>();
			map.put("id", r.getId());
			map.put("name",r.getName());
			
			if(resources.getPid()!=null&&r.getPid()!=null&&resources.getPid().equals(r.getId())){
				map.put("selected",true);
			}else{
				map.put("selected",false);
			}
			mapList.add(map);
		}
		return mapList;
	}

	@Override
	public List<String> findResourceListByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return resourcesMapper.findResourceListByRoleId(roleId);
	}

	@Override
	public List<Map<String, Object>> findResourceListByType() {
			Map<String,Object> map=new HashMap<>();
			map.put("type", "1");
			map.put("id",( (User)SecurityUtils.getSubject().getPrincipal()).getId());
			
		return resourcesMapper.findResourceListByType(map);
	}

	

}
