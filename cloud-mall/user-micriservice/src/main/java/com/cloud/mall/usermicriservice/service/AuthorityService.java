package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.dto.AuthorityReqDTO;
import com.cloud.mall.usermicriservice.dto.BaseRespDTO;

/**
 * Authority
 *
 * @author Jon_China
 * @create 2017/11/18
 */
public interface AuthorityService {
    /**
     * 保存权限信息
     * @return
     */
    BaseRespDTO saveAuthority(AuthorityReqDTO request);
}
