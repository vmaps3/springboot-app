package com.wangsong.system.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Resources  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4125580367922291000L;
	@NotNull(message="id不能是null")
	@Length(max=50,message="id长度小于50")
	private String id;
	@Length(max=50,message="pid长度小于50")
    private String pid;
	@Length(max=50,message="name长度小于50")
    private String name;
	@Length(max=50,message="url长度小于50")
    private String url;
	@Length(max=50,message="type长度小于50")
    private String type;
	@Length(max=50,message="sort长度小于50")
    private String sort;
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		 this.type = type == null ? null : type.trim();
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		 this.sort = sort == null ? null : sort.trim();	
	}
}