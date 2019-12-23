package com.partern.bean;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private int m_id;           //消息id
    private String u_id1;       //用户1id
    private String u_id2;       //用户2id
    private String m_date;      //消息时间
    private String m_content;   //消息内容

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
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

    public String getM_date() {
        return m_date;
    }

    public void setM_date(String m_date) {
        this.m_date = m_date;
    }

    public String getM_content() {
        return m_content;
    }

    public void setM_content(String m_content) {
        this.m_content = m_content;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "m_id=" + m_id +
                ", u_id1='" + u_id1 + '\'' +
                ", u_id2='" + u_id2 + '\'' +
                ", m_date='" + m_date + '\'' +
                ", m_content='" + m_content + '\'' +
                '}';
    }
}