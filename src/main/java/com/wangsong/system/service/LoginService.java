package com.wangsong.system.service;

import javax.servlet.http.HttpServletRequest;

import com.wangsong.common.model.Result;
import com.wangsong.system.entity.User;

import java.io.UnsupportedEncodingException;

public interface LoginService {


    String loginPost(User user) throws UnsupportedEncodingException;

    void logoutJSON();

    String getStatus(HttpServletRequest request);
}
