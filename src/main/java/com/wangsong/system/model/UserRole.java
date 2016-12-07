package com.wangsong.system.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserRole  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2146055323640680310L;
	@NotNull(message="id不能是null")
	@Length(max=50,message="id长度小于50")
	private String id;
	@Length(max=50,message="userId长度小于50")
    private String userId;
	@Length(max=50,message="roleId长度小于50")
    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}