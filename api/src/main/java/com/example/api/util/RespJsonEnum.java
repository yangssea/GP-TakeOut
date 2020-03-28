package com.example.api.util;

public enum  RespJsonEnum {
    SUCCESS(200,"请求成功!"),
    ERROR(500,"服务器错误!"),
    NO_TOKEN_ERROR(1001,"无token信息,请登录!"),
    ERROR_TOKEN_ERROR(1002,"token解析错误,请重新登录!"),
    EXPIRED_TOKEN_ERROR(1003,"token信息已过期,请重新登录!");

    private int status;
    private String message;

    RespJsonEnum(int status,String message){
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
