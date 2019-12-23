package com.partern.bean;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {

    private int a_id;       //活动id
    private String u_id;    //用户id
    private String a_date;  //活动日期
    private int a_type;     //活动类型
    private String a_content;   //活动内容

    public Activity() {
    }


    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }

    public int getA_type() {
        return a_type;
    }

    public void setA_type(int a_type) {
        this.a_type = a_type;
    }

    public String getA_content() {
        return a_content;
    }

    public void setA_content(String a_content) {
        this.a_content = a_content;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "a_id=" + a_id +
                ", u_id='" + u_id + '\'' +
                ", a_date='" + a_date + '\'' +
                ", a_type=" + a_type +
                ", a_content='" + a_content + '\'' +
                '}';
    }
}