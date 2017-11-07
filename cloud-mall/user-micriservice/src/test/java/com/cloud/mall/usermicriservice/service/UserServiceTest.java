package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
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
}
