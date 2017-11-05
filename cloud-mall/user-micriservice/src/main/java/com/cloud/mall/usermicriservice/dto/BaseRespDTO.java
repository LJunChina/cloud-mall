package com.cloud.mall.usermicriservice.dto;

import com.cloud.mall.usermicriservice.enums.ResultCode;

import java.io.Serializable;

public class BaseRespDTO implements Serializable {
    private static final long serialVersionUID = -7964635136197468217L;

    private Serializable data;

    private String code;

    private String message;


    public BaseRespDTO() {
        this.code = ResultCode.OK.getCode();
    }

    public BaseRespDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

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
}
