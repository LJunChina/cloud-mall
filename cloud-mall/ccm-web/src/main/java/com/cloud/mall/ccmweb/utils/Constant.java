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
    public static final String CHECK_TOKEN = USER_SERVICE + "/token/check-token/{1}";
    /**根据用户id查询用户信息*/
    public static final String GET_USER_INFO_BY_ID = USER_SERVICE + "/get-user-detail/{1}";
    /**根据条件查询用户列表*/
    public static final String GET_USER_LIST = USER_SERVICE + "/get-user-list?message={1}";
    /**保存角色信息*/
    public static final String SAVE_ROLE_INFO = USER_SERVICE + "/role/save-role";
    /**保存权限信息*/
    public static final String SAVE_AUTHORITY = USER_SERVICE + "/auth/save-auth";
}
