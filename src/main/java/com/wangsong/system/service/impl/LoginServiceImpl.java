package com.wangsong.system.service.impl;


import com.wangsong.common.model.CodeEnum;
import com.wangsong.system.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {





    @Override
    public void logoutJSON() {

    }

    @Override
    public String getStatus(HttpServletRequest request) {
        return request.getAttribute("javax.servlet.error.status_code").toString();
    }

}


