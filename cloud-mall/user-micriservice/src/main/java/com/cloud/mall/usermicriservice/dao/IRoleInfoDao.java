package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.model.RoleInfo;
import org.springframework.stereotype.Repository;

@Repository(value = "userInfoDao")
public interface IRoleInfoDao {
    int addRoleInfo(RoleInfo roleInfo);
}
