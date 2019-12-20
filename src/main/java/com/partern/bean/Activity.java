package com.partern.bean;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {

//    private int a_id;       //活动id
//    private String u_id;    //用户id
//    private String a_date;  //活动日期
//    private int a_type;     //活动类型
//    private String a_content;   //活动内容

    private Integer aId;

    private String uId;

    private Date aDate;

    private Integer aType;

    private String aContent;

    private static final long serialVersionUID = 1L;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public Integer getaType() {
        return aType;
    }

    public void setaType(Integer aType) {
        this.aType = aType;
    }

    public String getaContent() {
        return aContent;
    }

    public void setaContent(String aContent) {
        this.aContent = aContent == null ? null : aContent.trim();
    }
}