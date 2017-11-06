package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import com.cloud.mall.usermicriservice.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;


public class UserDaoTest extends UserMicriserviceApplicationTests {

    @Autowired
    private IUserDao userDao;

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("test");
        user.setPassword("123456");
        Assert.assertEquals(1,this.userDao.saveUser(user));
    }

    @Test
    public void testGetUserInfo(){
        User user = new User();
        user.setId("342dc4fd-ddeb-42ad-87b8-a53ab1ab45ea");
        user.setName("test");
        Assert.assertNotNull(this.userDao.getUserInfo(user));
    }

    @Test
    public void testUpdateUserById(){
        User user = new User();
        user.setId("342dc4fd-ddeb-42ad-87b8-a53ab1ab45ea");
        user = this.userDao.getUserInfo(user);
        user.setUsername("JUnit");
        user.setEmail("3131@qq.com");
        Assert.assertEquals(1,this.userDao.updateUserById(user));
    }
}
