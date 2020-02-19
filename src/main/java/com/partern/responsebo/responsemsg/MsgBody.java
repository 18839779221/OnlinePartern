package com.partern.responsebo.responsemsg;

import com.partern.bean.Message;

import java.io.Serializable;

public class MsgBody implements Serializable {
    public static final int OUT=1;
    public static final int IN=2;

    private int type;
    private String time;
    private String msg;

    public MsgBody() {
    }

    public MsgBody(Message message,String id) {
        type = message.getU_id2().equals(id)?OUT:IN;
        time = message.getM_date();
        msg = message.getM_content();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MsgBody{" +
                "type=" + type +
                ", time='" + time + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
