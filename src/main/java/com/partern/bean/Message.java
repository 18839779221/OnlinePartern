package com.partern.bean;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
//    private int m_id;           //消息id
//    private String u_id1;       //用户1id
//    private String u_id2;       //用户2id
//    private String m_date;      //消息时间
//    private String m_content;   //消息内容

    private Integer mId;

    private String uId1;

    private String uId2;

    private Date mDate;

    private String mContent;

    private static final long serialVersionUID = 1L;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
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

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent == null ? null : mContent.trim();
    }
}