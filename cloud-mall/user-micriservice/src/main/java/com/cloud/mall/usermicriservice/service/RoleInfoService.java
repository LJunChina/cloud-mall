package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.dto.BaseRespDTO;

public interface RoleInfoService {
    /**
     * 添加角色信息
     * @param roleName
     * @return
     */
    BaseRespDTO saveRoleInfo(String roleName);
}
