package com.cloud.mall.ccmweb.utils;

/**
 * 各服务接口
 *
 * @author Jon_China
 * @create 2017/11/11
 */
public final class Constant {
    /**用户服务*/
    public static final String USER_SERVICE = "http://user-micriservice";

    /**获取公钥*/
    public static final String GET_PUBLIC_KEY = USER_SERVICE + "/get-public-key";
    /**用户登录*/
    public static final String USER_LOGIN = USER_SERVICE + "/login";
    /**检测token是否有效*/
    public static final String CHECK_TOKEN = USER_SERVICE + "/check-token/{1}";
}
