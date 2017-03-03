package com.wangsong.system.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Role  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3582588209589180635L;
	@NotNull(message="id不能是null")
	@Length(max=50,message="id长度小于50")
	private String id;
	
	@Length(max=50,message="name长度小于50")
    private String name;

	private String[] resourcesId;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public String[] getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(String[] resourcesId) {
		this.resourcesId = resourcesId;
	}
    
    
}