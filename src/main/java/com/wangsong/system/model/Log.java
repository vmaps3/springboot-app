package com.wangsong.system.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Log  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4947347940116804022L;
	@NotNull(message="id不能是null")
	@Length(max=50,message="id长度小于50")
	private String id;
	@Length(max=500,message="url长度小于500")
    private String url;
	@Length(max=400,message="parameter长度小于400")
    private String parameter;
	@Length(max=50,message="remoteAddr长度小于50")
    private String remoteAddr;
	@Length(max=500,message="agent长度小于500")
    private String agent;

    private Date beginTime;

    private Date endTime;
    
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

   
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr == null ? null : remoteAddr.trim();
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}