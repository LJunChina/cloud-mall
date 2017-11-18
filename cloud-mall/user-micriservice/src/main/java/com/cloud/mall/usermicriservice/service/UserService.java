package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.dto.UserDetailRespDTO;
import com.cloud.mall.usermicriservice.dto.UserSearchRespDTO;

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
     * @param request
     * @return
     */
    BaseRespDTO getUserList(UserSearchRespDTO request);

    /**
     * 根据userId查询用户信息
     * @param userId
     * @return
     */
    UserDetailRespDTO getUserInfo(String userId);
}
