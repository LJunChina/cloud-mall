package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(value = "com.cloud.mall.usermicriservice.dao")
public class UserDaoTest {

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
