package com.wangsong.system.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class RoleResources  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2814639517974791520L;
	@NotNull(message="id不能是null")
	@Length(max=50,message="id长度小于50")
	private String id;
	@Length(max=50,message="resourcesId长度小于50")
    private String resourcesId;
	@Length(max=50,message="roleId长度小于50")
    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId == null ? null : resourcesId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}