package com.wangsong.system.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Dict  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3138060792826655366L;
	@NotNull(message="id不能是null")
	@Length(max=50,message="id长度小于50")
	private String id;
	@Length(max=50,message="name长度小于50")
    private String name;
	@Length(max=50,message="type长度小于50")
    private String type;
	@Length(max=50,message="code长度小于50")
    private String code;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}
    
    
}