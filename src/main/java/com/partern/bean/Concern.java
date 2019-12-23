package com.partern.bean;

import java.io.Serializable;

public class Concern implements Serializable {
    private int f_id;       //关注id
    private String u_id1;   //关注者
    private String u_id2;   //被关注者
    private int f_state;    //关注状态

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getU_id1() {
        return u_id1;
    }

    public void setU_id1(String u_id1) {
        this.u_id1 = u_id1;
    }

    public String getU_id2() {
        return u_id2;
    }

    public void setU_id2(String u_id2) {
        this.u_id2 = u_id2;
    }

    public int getF_state() {
        return f_state;
    }

    public void setF_state(int f_state) {
        this.f_state = f_state;
    }

    public Concern() {
    }

    @Override
    public String toString() {
        return "Concern{" +
                "f_id=" + f_id +
                ", u_id1='" + u_id1 + '\'' +
                ", u_id2='" + u_id2 + '\'' +
                ", f_state=" + f_state +
                '}';
    }
}