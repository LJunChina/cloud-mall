package com.cloud.mall.usermicriservice.service.impl;

import com.cloud.mall.usermicriservice.dao.IUserDao;
import com.cloud.mall.usermicriservice.dto.BaseRespDTO;
import com.cloud.mall.usermicriservice.enums.ResultCode;
import com.cloud.mall.usermicriservice.model.User;
import com.cloud.mall.usermicriservice.utils.SSOUtil;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.cloud.mall.usermicriservice.service.UserService;
import com.cloud.mall.usermicriservice.utils.EmptyChecker;
import com.cloud.mall.usermicriservice.utils.RSAEncrypt;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IUserDao userDao;

    @Override
    public BaseRespDTO userLogin(String userName, String password) throws Exception {
        if(EmptyChecker.isEmpty(userName)){
            return new BaseRespDTO(ResultCode.USER_NAME_NOT_ALLOW_EMPTY);
        }
        if(EmptyChecker.isEmpty(password)){
            return new BaseRespDTO(ResultCode.PASSWORD_NOT_ALLOW_EMPTY);
        }
        //解密
        ClassPathResource resource = new ClassPathResource("/privateKey.keystore");
        String privateKeyPath = resource.getFile().getPath();
        String privateKeyStr = RSAEncrypt.loadKeyByFile(privateKeyPath);
        RSAPrivateKey privateKey = RSAEncrypt.loadPrivateKeyByStr(privateKeyStr);
        byte[] passwordByte = RSAEncrypt.decrypt(privateKey,Base64.decode(password));
        if(EmptyChecker.isEmpty(passwordByte)){
            return new BaseRespDTO(ResultCode.FAIL);
        }
        String realPassword = DigestUtils.sha256Hex(new String(passwordByte));
        //查询用户信息
        User param = new User();
        param.setUsername(userName);
        User currentUser = this.userDao.getUserInfo(param);
        if(EmptyChecker.isEmpty(currentUser)){
            return new BaseRespDTO(ResultCode.USER_NAME_OR_PASSWORD_ERROR);
        }
        //加密
        String originPassword = currentUser.getPassword();
        //密码比对
        if(!originPassword.equals(realPassword)){
            return new BaseRespDTO(ResultCode.USER_NAME_OR_PASSWORD_ERROR);
        }
        //写入redis
        String tokenId = SSOUtil.generatorTokenId();
        this.redisTemplate.opsForValue().set(tokenId,currentUser,15L, TimeUnit.MINUTES);
        BaseRespDTO result = new BaseRespDTO();
        result.setData(tokenId);
        return result;
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
