package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.model.Authority;
import org.springframework.stereotype.Repository;

@Repository(value = "authorityDao")
public interface IAuthorityDao {
    /**
     * 新增权限
     * @param authority
     * @return
     */
    int addAuthority(Authority authority);
}
