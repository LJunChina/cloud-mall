package com.cloud.mall.usermicriservice.model;


import java.io.Serializable;

public class AuthorityRule implements Serializable {


    private static final long serialVersionUID = -4735760305787725832L;
    /**
     * 
     * authority_rule.auth_id
     */
    private String authId;

    /**
     * 
     * authority_rule.role_id
     */
    private String roleId;


    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
