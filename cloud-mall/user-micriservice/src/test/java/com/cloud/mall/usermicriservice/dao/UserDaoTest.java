package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import com.cloud.mall.usermicriservice.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;


public class UserDaoTest extends UserMicriserviceApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("test");
        Assert.assertEquals(1,this.userDao.saveUser(user));
    }
}
