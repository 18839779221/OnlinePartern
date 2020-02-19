package com.partern.responsebo.responsemsg;

import com.partern.bean.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseMsg implements Serializable {
    private List<MsgBody> msg;
    private String phone;
    private String nick;
    private String lastChatTime;

    public ResponseMsg() {
    }

    public ResponseMsg(String id2, String nick, List<Message> messages) {
        msg = new ArrayList<>();
        messages.forEach(message -> {
            msg.add(new MsgBody(message,id2));
        });
        this.phone = id2;
        this.nick = nick;
        if(messages.size()>0){
            lastChatTime = messages.get(0).getM_date();
        }
    }

    public List<MsgBody> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBody> msg) {
        this.msg = msg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getLastChatTime() {
        return lastChatTime;
    }

    public void setLastChatTime(String lastChatTime) {
        this.lastChatTime = lastChatTime;
    }

    @Override
    public String toString() {
        return "ResponseMsg{" +
                "msg=" + msg +
                ", phone='" + phone + '\'' +
                ", nick='" + nick + '\'' +
                ", lastChatTime='" + lastChatTime + '\'' +
                '}';
    }
}
