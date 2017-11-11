package com.cloud.mall.usermicriservice.service.impl;

import com.cloud.mall.usermicriservice.model.TokenInfo;
import com.cloud.mall.usermicriservice.service.TokenService;
import com.cloud.mall.usermicriservice.utils.SSOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
/**
 * token服务
 *
 * @author Jon_China
 * @create 2017/11/11
 */
@Service(value = "tokenService")
public class TokenServiceImpl implements TokenService {

    private static final long TIME_OUT = 3000L;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public TokenInfo addTokenInfo(TokenInfo tokenInfo) {
        redisTemplate.opsForValue().set(SSOUtil.generatorTokenId(),tokenInfo,TIME_OUT, TimeUnit.SECONDS);
        return tokenInfo;
    }

    @Override
    public boolean deleteTokenInfo(TokenInfo tokenInfo) {
        return false;
    }

    @Override
    public TokenInfo refreshTokenInfo(TokenInfo tokenInfo) {
        return null;
    }
}
