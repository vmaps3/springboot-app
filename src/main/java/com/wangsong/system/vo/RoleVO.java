package com.wangsong.system.vo;

import java.util.List;

import com.wangsong.system.model.RoleResources;

public class RoleVO {
    private List<RoleResources> roleResourcesList;

    private String id;
    private String name;
    private String pid;


    public List<RoleResources> getRoleResourcesList() {
        return roleResourcesList;
    }

    public void setRoleResourcesList(List<RoleResources> roleResourcesList) {
        this.roleResourcesList = roleResourcesList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
