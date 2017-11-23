package com.cloud.mall.usermicriservice.service.impl;

import com.cloud.mall.usermicriservice.dao.IAuthorityDao;
import com.cloud.mall.usermicriservice.dto.AuthorityReqDTO;
import com.cloud.mall.usermicriservice.dto.AuthorityRespDTO;
import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import com.cloud.mall.usermicriservice.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Jon_China
 * @create 2017/11/18
 */
@Service(value = "authorityService")
public class AuthorityServiceImpl implements AuthorityService {


    @Autowired
    private IAuthorityDao authorityDao;

    @Override
    public BaseRespDTO saveAuthority(AuthorityReqDTO request) {
        request.setId(UUID.randomUUID().toString());
        int row = this.authorityDao.addAuthority(request);
        if(1 == row){
            return new BaseRespDTO();
        }
        return new BaseRespDTO(ResultCode.FAIL);
    }

    /**
     * 获取系统所有菜单信息
     *
     * @param appName 系统名称
     * @return
     */
    @Override
    public AuthorityRespDTO getAllMenus(String appName) {
        AuthorityReqDTO reqDTO = new AuthorityReqDTO();
        reqDTO.setAppName(appName);
        AuthorityRespDTO baseRespDTO = new AuthorityRespDTO();
        baseRespDTO.setResultData(this.authorityDao.getAllAuthorities(reqDTO));
        return baseRespDTO;
    }
}
