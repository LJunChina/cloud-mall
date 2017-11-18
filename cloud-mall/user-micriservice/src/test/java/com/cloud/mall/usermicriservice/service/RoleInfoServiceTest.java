package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * RoleInfoServiceTest
 *
 * @author Jon_China
 * @create 2017/11/18
 */
public class RoleInfoServiceTest extends UserMicriserviceApplicationTests {

    @Autowired
    private RoleInfoService roleInfoService;

    @Test
    public void testSaveRoleInfo(){
        BaseRespDTO baseRespDTO = this.roleInfoService.saveRoleInfo("产品经理");
        Assert.assertEquals(ResultCode.OK.getCode(),baseRespDTO.getCode());
    }
}
