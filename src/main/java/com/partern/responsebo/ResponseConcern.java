package com.partern.responsebo;

import com.partern.bean.Concern;

import java.io.Serializable;

public class ResponseConcern implements Serializable {

    public static final int CONCERN_STATE_NONE = 0;
    public static final int CONCERN_STATE_CONCERN = 1;
    public static final int CONCERN_STATE_FANS = 2;
    public static final int CONCERN_STATE_CONCERNEACH = 3;

    private String phone;
    private String nick;
    private int state;      //关注状态，0:互不关注，1:我关注了他，2:他关注了我，3:相互关注

    public ResponseConcern(String phone, String nick, int state) {
        this.phone = phone;
        this.nick = nick;
        this.state = state;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ResponseConcern() {}

    @Override
    public String toString() {
        return "ResponseConcern{" +
                "phone='" + phone + '\'' +
                ", nick='" + nick + '\'' +
                ", state=" + state +
                '}';
    }
}
