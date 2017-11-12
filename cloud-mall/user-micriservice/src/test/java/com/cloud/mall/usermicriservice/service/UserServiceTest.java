package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.model.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends UserMicriserviceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testGetPublicKey() throws Exception{
        Assert.assertNotNull(this.userService.getPublicKey().getData());
    }
    @Test
    public void testUserLogin() throws Exception{
        BaseRespDTO respDTO = this.userService.userLogin("JUnit","123456");
        Assert.assertNotNull(respDTO);
    }
    @Test
    public void testGetUserList(){
        UserVO userVO = new UserVO();
        userVO.setPageNum(1);
        userVO.setPageSize(10);
        Assert.assertNotNull(this.userService.getUserList(userVO).getData());
    }
}
