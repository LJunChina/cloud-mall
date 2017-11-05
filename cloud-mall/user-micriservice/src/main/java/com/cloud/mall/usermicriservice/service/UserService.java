package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.dto.BaseRespDTO;

public interface UserService {
    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    BaseRespDTO userLogin(String userName,String password);
}
