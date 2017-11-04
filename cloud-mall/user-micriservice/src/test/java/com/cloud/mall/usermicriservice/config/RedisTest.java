package com.cloud.mall.usermicriservice.config;

import com.cloud.mall.usermicriservice.UserMicriserviceApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;

public class RedisTest extends UserMicriserviceApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringRedis(){
        String key = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(key,"JunChina");
        Assert.assertEquals("JunChina",stringRedisTemplate.opsForValue().get(key));
    }
}
