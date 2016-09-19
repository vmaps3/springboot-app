package com.wangsong.sys.model;

public class Resources {
    private String id;

    private String pid;

    private String name;

    private String url;
    
    private String type;
    
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
}