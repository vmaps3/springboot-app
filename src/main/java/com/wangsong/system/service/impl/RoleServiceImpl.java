package com.wangsong.system.service.impl;

import com.wangsong.common.model.JsonTreeData;
import com.wangsong.common.model.Result;
import com.wangsong.common.util.TreeNodeUtil;
import com.wangsong.system.dao.RoleMapper;
import com.wangsong.system.dao.RoleResourcesMapper;
import com.wangsong.system.model.*;
import com.wangsong.system.service.RoleService;
import com.wangsong.system.service.UserService;
import com.wangsong.system.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleResourcesMapper roleResourcesMapper;


    @Override
    public Result insertRole(RoleAddModel role) {
        String[] resourcesId = role.getResourcesId();
        role.setId(UUID.randomUUID().toString());
        roleMapper.insertRoleAddModel(role);
        if (resourcesId == null) {
            return new Result("success", null);
        }
        for (int i = 0; i < resourcesId.length; i++) {
            roleResourcesMapper.insert(new RoleResources(UUID.randomUUID().toString()
                    , resourcesId[i], role.getId()));
        }
        return new Result("success", null);
    }

    @Override
    public Result updateRole(RoleAddModel role) {
        String[] resourcesId = role.getResourcesId();
        roleResourcesMapper.deleteByT(new RoleResources[]{new RoleResources(null, null, role.getId())});
        roleMapper.updateByPrimaryKeyRoleAddModel(role);
        if (resourcesId == null) {
            return new Result("success", null);
        }
        for (int i = 0; i < resourcesId.length; i++) {
            roleResourcesMapper.insert(new RoleResources(UUID.randomUUID().toString(), resourcesId[i], role.getId()));
        }
        return new Result("success", null);
    }

    @Override
    public Result deleteRole(String[] id) {
        RoleResources[] r = new RoleResources[id.length];
        UserRole[] u = new UserRole[id.length];
        for (int i = 0; i < id.length; i++) {
            r[i] = new RoleResources(null, null, id[i]);
            u[i] = new UserRole(null, null, id[i]);
        }

        userService.deleteByT(u);
        roleResourcesMapper.deleteByT(r);
        roleMapper.deleteBy(id);
        return new Result("success", null);
    }

    @Override
    public Object findTByPage() {
        List<Role> resourcesList = roleMapper.selectAll();
        return resourcesToJsonTreeData(resourcesList);
    }

    private List<JsonTreeData> resourcesToJsonTreeData(List<Role> resourcesList) {
        List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
        /*为了整理成公用的方法，所以将查询结果进行二次转换。
         * 其中specid为主键ID，varchar类型UUID生成
         * parentid为父ID
         * specname为节点名称
         * */
        for (Role htSpecifications : resourcesList) {
            JsonTreeData treeData = new JsonTreeData(htSpecifications.getId()
                    , htSpecifications.getPid(), htSpecifications.getName(), null
                    , null, null);
            treeDataList.add(treeData);
        }
        //最后得到结果集,经过FirstJSON转换后就可得所需的json格式
        List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
        return newTreeDataList;
    }

    @Override
    public RoleVO selectByPrimaryKey(String id) {
        RoleVO role = roleMapper.selectRoleVOByPrimaryKey(id);
        role.setRoleResourcesList(roleResourcesMapper.findTByT(new RoleResources(null, null, id)));
        return role;
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public void deleteByT(RoleResources[] r) {
        roleResourcesMapper.deleteByT(r);
    }

    @Override
    public List<Resources> findResourcesByT(Resources resources) {
        return roleResourcesMapper.findResourcesByT(resources);
    }
}
