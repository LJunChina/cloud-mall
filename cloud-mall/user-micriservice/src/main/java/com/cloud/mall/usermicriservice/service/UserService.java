package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.dto.BaseRespDTO;

public interface UserService {
    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    BaseRespDTO userLogin(String userName,String password) throws Exception;

    /**
     * 获取公钥信息
     * @return
     * @throws Exception
     */
    BaseRespDTO getPublicKey() throws Exception;

    /**
     * 用户列表查询
     * @return
     */
    BaseRespDTO getUserList();
}
