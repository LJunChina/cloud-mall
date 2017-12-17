package com.cloud.mall.usermicriservice.model;


import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -2635974089869998486L;
    /**
     *
     * user.id
     */
    private String id;

    /**
     *
     * user.username
     */
    private String userName;

    /**
     *
     * user.password
     */
    private String password;

    /**
     * 姓名
     * user.name
     */
    private String name;

    /**
     * 0:女
     * user.sex
     */
    private String sex;

    /**
     * 0:禁用
     * user.status
     */
    private String status;

    /**
     * 部门ID
     * user.orgid
     */
    private String orgId;

    /**
     *
     * user.email
     */
    private String email;

    /**
     * 身份证号
     * user.idcard
     */
    private String idCard;

    /**
     * 是否是管理员
     * user.is_admin
     */
    private String isAdmin;

    /**
     *
     * user.mobile
     */
    private String mobile;

    /**
     * 当次登录token
     */
    private String loginToken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }
}
