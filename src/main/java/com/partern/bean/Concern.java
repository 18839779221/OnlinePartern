package com.partern.bean;

import java.io.Serializable;

public class Concern implements Serializable {
//    private int f_id;       //关注id
//    private String u_id1;   //关注者
//    private String u_id2;   //被关注者
//    private int f_state;    //关注状态

    private Integer fId;

    private String uId1;

    private String uId2;

    private Integer fState;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getuId1() {
        return uId1;
    }

    public void setuId1(String uId1) {
        this.uId1 = uId1 == null ? null : uId1.trim();
    }

    public String getuId2() {
        return uId2;
    }

    public void setuId2(String uId2) {
        this.uId2 = uId2 == null ? null : uId2.trim();
    }

    public Integer getfState() {
        return fState;
    }

    public void setfState(Integer fState) {
        this.fState = fState;
    }
}