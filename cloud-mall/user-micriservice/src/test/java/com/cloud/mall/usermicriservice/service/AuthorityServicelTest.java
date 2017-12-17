package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import com.cloud.mall.usermicriservice.dto.AuthorityRespDTO;
import com.cloud.mall.usermicriservice.dto.MenuRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AuthorityServicelTest extends UserMicriserviceApplicationTests {

    @Autowired
    private AuthorityService authorityService;

    @Test
    public void getAllMenus() throws Exception {
        MenuRespDTO authorityRespDTO = this.authorityService.getAllMenus("cloud_mall");
        Assert.assertEquals(ResultCode.OK.getCode(),authorityRespDTO.getCode());
    }

}