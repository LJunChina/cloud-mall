package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.dto.AuthorityReqDTO;
import com.cloud.mall.usermicriservice.model.Authority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "authorityDao")
public interface IAuthorityDao {
    /**
     * 新增权限
     * @param request
     * @return
     */
    int addAuthority(AuthorityReqDTO request);

    /**
     * 获取所有菜单
     * @param request
     * @return
     */
    List<Authority> getAllAuthorities(AuthorityReqDTO request);
}
