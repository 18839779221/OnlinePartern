package com.partern.websocket;

import java.io.Serializable;

public class MsgPayload implements Serializable {
    String msg;
    String nick;

    public MsgPayload(){}

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "MsgPayload{" +
                "msg='" + msg + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}
