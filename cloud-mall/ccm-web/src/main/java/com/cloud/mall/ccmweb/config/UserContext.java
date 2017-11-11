package com.cloud.mall.ccmweb.config;

import com.cloud.mall.ccmweb.model.LoginUser;

/**
 * 当前登录用户上下文
 *
 * @author Jon_China
 * @create 2017/11/11
 */
public final class UserContext {

    static ThreadLocal<LoginUser> userContext = new ThreadLocal<>();

    public static void addLoginUserContext(){
        LoginUser loginUser = new LoginUser();
        userContext.set(loginUser);
    }
}
