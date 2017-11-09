package com.cloud.mall.ccmweb.enums;

public enum ResultCode {
    OK("0000","处理成功"),
    FAIL("9000","处理失败"),
    ERROR("9999","服务器异常,请稍后再试"),
    USER_NAME_NOT_ALLOW_EMPTY("9010","用户名称不能为空"),
    PASSWORD_NOT_ALLOW_EMPTY("9011","登录密码不能为空"),
    INVALID_CODE("9013","验证码错误"),
    USER_NAME_OR_PASSWORD_ERROR("9012","用户名或密码错误");


    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    ResultCode(String code, String message){
        this.code = code;
        this.message = message;
    }
}
