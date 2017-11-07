package com.cloud.mall.usermicriservice.service.impl;

import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import com.cloud.mall.usermicriservice.model.User;
import com.cloud.mall.usermicriservice.service.UserService;
import com.cloud.mall.usermicriservice.utils.EmptyChecker;
import com.cloud.mall.usermicriservice.utils.RSAEncrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public BaseRespDTO userLogin(String userName, String password) {
        if(EmptyChecker.isEmpty(userName)){
            return new BaseRespDTO(ResultCode.USER_NAME_NOT_ALLOW_EMPTY);
        }
        if(EmptyChecker.isEmpty(password)){
            return new BaseRespDTO(ResultCode.PASSWORD_NOT_ALLOW_EMPTY);
        }
        //解密
        //加密
        //查询用户信息
        //密码比对
        //写入redis
        //redisTemplate.opsForValue().set(UUID.randomUUID().toString().toUpperCase(),new User(),30L, TimeUnit.MINUTES);
        return new BaseRespDTO();
    }

    @Override
    public BaseRespDTO getPublicKey() throws Exception {
        BaseRespDTO baseRespDTO = new BaseRespDTO();
        ClassPathResource resource = new ClassPathResource("/publicKey.keystore");
        String keyPath = resource.getFile().getPath();
        baseRespDTO.setData(RSAEncrypt.loadKeyByFile(keyPath));
        return baseRespDTO;
    }
}
