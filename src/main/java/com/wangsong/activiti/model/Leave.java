package com.wangsong.activiti.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Leave {
	@NotNull(message="id不能是null")
	@Length(max=50,message="id长度小于50")
    private String id;
	@Length(max=50,message="days长度小于50")
    private String days;
	@Length(max=50,message="reason长度小于50")
    private String reason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}