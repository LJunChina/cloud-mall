package com.cloud.mall.usermicriservice.enums;

public enum ResultCode {
    OK("0000","处理成功"),
    FAIL("9000","处理失败");


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
    ResultCode(String code,String message){
        this.code = code;
        this.message = message;
    }
}
