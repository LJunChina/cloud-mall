package com.cloud.mall.ccmweb.config;

import com.cloud.mall.ccmweb.exception.UserAuthException;
import com.cloud.mall.ccmweb.model.LoginUser;
import com.cloud.mall.ccmweb.utils.EmptyChecker;

/**
 * 当前登录用户上下文
 *
 * @author Jon_China
 * @create 2017/11/11
 */
public final class LoginUserContext {

    private static ThreadLocal<LoginUser> userContext = new ThreadLocal<>();


    public static void addLoginUserContext(LoginUser loginUser){
        if(EmptyChecker.isEmpty(loginUser)){
            throw new UserAuthException("非法用户");
        }
        userContext.set(loginUser);
    }


}
