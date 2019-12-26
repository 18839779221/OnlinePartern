package com.partern.responsebo;

import com.partern.utils.ResponseEnum;

import java.io.Serializable;

public class Header implements Serializable {

    private int code;
    private String msg;
    private String token;
    private String timestamp;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Header(){}

    public Header(int code, String msg, String token, String timestamp) {
        this.code = code;
        this.msg = msg;
        this.token = token;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Header{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    public void setType(ResponseEnum resType) {
        this.code = resType.getCode();
        this.msg = resType.getMessage();
    }
}
