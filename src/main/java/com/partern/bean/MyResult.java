package com.partern.bean;


import java.io.Serializable;
import java.util.List;

public class MyResult implements Serializable {

    public int code;
    public String msg;
    public List<?> list;
    public Object object;

    public MyResult(){ }

    public MyResult(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public MyResult(int code, String msg, List<?> list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
    }

    @Override
    public String toString() {
        return "MyResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", list=" + list +
                ", object=" + object +
                '}';
    }
}
