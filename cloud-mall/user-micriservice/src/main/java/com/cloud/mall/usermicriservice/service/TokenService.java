package com.cloud.mall.usermicriservice.service;

import com.cloud.mall.usermicriservice.model.TokenInfo;

/**
 * token服务
 *
 * @author Jon_China
 * @create 2017/11/11
 */
public interface TokenService {

    TokenInfo addTokenInfo(TokenInfo tokenInfo);

    boolean deleteTokenInfo(TokenInfo tokenInfo);

    TokenInfo refreshTokenInfo(TokenInfo tokenInfo);
}
