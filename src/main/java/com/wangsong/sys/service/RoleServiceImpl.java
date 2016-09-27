package com.wangsong.sys.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wangsong.sys.dao.RoleMapper;
import com.wangsong.sys.dao.RoleResourcesMapper;
import com.wangsong.sys.dao.UserRoleMapper;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.util.Page;


@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleServiceI {
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
		roleResourcesMapper.deleteByRole(role);
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
	public int delete(String id) {
		Role role=new Role();
		role.setId(id);
		userRoleMapper.deleteByRole(role);
		roleResourcesMapper.deleteByRole(role);
		return roleMapper.deleteByPrimaryKey(id);
	}



	@Override
	public List<RoleResources> selectRoleResourcesAll(Role mrole) {
		List<RoleResources> userRoleList= roleResourcesMapper.selectByRole(mrole);		
		return userRoleList;
	}

	@Override
	public List<String> findRoleIdListByUserId(String id) {
		return userRoleMapper.findRoleIdListByUserId(id);
	}

	@Override
	public Page selectAll(Page page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		 List<Role> userList=roleMapper.selectAll();
		 page.setResult(userList);
		 int  count=roleMapper.selectAllCount();
		 page.setTotalCount(count);
		 return page;
	}

}
