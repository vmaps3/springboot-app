package com.wangsong.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wangsong.sys.dao.ResourcesMapper;
import com.wangsong.sys.dao.RoleMapper;
import com.wangsong.sys.dao.RoleResourcesMapper;
import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.Role;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.model.User;
import com.wangsong.sys.model.UserRole;
import com.wangsong.sys.util.Attributes;
import com.wangsong.sys.util.JsonTreeData;
import com.wangsong.sys.util.Page;
import com.wangsong.sys.util.TreeNodeUtil;


@Service
public class ResourcesServiceImpl extends BaseServiceImpl <Resources> implements ResourcesServiceI {
	@Autowired
	private ResourcesMapper resourcesMapper;
	
	@Override
	public int insert(Resources resources) {
		String id = UUID.randomUUID().toString();
		resources.setId(id);
		return resourcesMapper.insert(resources);
	}

	@Override
	public List<String> findResourceListByRoleId(String roleId) {
		return resourcesMapper.findResourceListByRoleId(roleId);
	}

	@Override
	public List<JsonTreeData> findResourceListByType() {
		List<Resources> resourcesList =resourcesMapper.selectAll();
		 List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
        /*为了整理成公用的方法，所以将查询结果进行二次转换。
         * 其中specid为主键ID，varchar类型UUID生成
         * parentid为父ID
         * specname为节点名称
         * */
       for (Resources htSpecifications : resourcesList) {
           JsonTreeData treeData = new JsonTreeData();
           treeData.setId(htSpecifications.getId());
           treeData.setPid(htSpecifications.getPid());
           treeData.setText(htSpecifications.getName());
           Attributes attributes=new Attributes();
           attributes.setUrl(htSpecifications.getUrl()); 
           treeData.setAttributes(attributes);
           treeDataList.add(treeData);
       }
       //最后得到结果集,经过FirstJSON转换后就可得所需的json格式
       List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
		return newTreeDataList;
	}
	
	@Override
	public List<JsonTreeData> findMapListByType() {
		List<Resources> resourcesList =resourcesMapper.findResourceListByType((User)SecurityUtils.getSubject().getPrincipal());
		 List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
         /*为了整理成公用的方法，所以将查询结果进行二次转换。
          * 其中specid为主键ID，varchar类型UUID生成
          * parentid为父ID
          * specname为节点名称
          * */
        for (Resources htSpecifications : resourcesList) {
            JsonTreeData treeData = new JsonTreeData();
            treeData.setId(htSpecifications.getId());
            treeData.setPid(htSpecifications.getPid());
            treeData.setText(htSpecifications.getName());
            Attributes attributes=new Attributes();
            attributes.setUrl(htSpecifications.getUrl()); 
            treeData.setAttributes(attributes);
            treeDataList.add(treeData);
        }
        //最后得到结果集,经过FirstJSON转换后就可得所需的json格式
        List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
		return newTreeDataList;
	}
	
}
