package com.partern.bean;

import java.io.Serializable;

public class User implements Serializable {

//    private String u_id;     //手机号
//    private String u_password;  //密码
//    private String u_nick;      //昵称
//    private int u_age;          //年龄
//    private int u_sex;          //性别
//    private String u_prof;      //职业
//    private int u_educate;      //学历
//    private int u_income;       //收入
//    private String u_addr;      //地址
//    private int u_height;       //身高
//    private String u_img;       //图片地址
//    private String u_note;      //个性签名
//    private int u_marrage;      //婚姻状况
//    private int u_like;         //点赞数
//    private int u_type;         //用户类型

    private String uId;

    private String uPassword;

    private String uNick;

    private Integer uAge;

    private Integer uSex;

    private String uProf;

    private Integer uEducate;

    private Integer uIncome;

    private String uAddr;

    private Integer uHeight;

    private String uImg;

    private String uNote;

    private Integer uMarrage;

    private Integer uLike;

    private Integer uType;

    private static final long serialVersionUID = 1L;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuNick() {
        return uNick;
    }

    public void setuNick(String uNick) {
        this.uNick = uNick == null ? null : uNick.trim();
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public Integer getuSex() {
        return uSex;
    }

    public void setuSex(Integer uSex) {
        this.uSex = uSex;
    }

    public String getuProf() {
        return uProf;
    }

    public void setuProf(String uProf) {
        this.uProf = uProf == null ? null : uProf.trim();
    }

    public Integer getuEducate() {
        return uEducate;
    }

    public void setuEducate(Integer uEducate) {
        this.uEducate = uEducate;
    }

    public Integer getuIncome() {
        return uIncome;
    }

    public void setuIncome(Integer uIncome) {
        this.uIncome = uIncome;
    }

    public String getuAddr() {
        return uAddr;
    }

    public void setuAddr(String uAddr) {
        this.uAddr = uAddr == null ? null : uAddr.trim();
    }

    public Integer getuHeight() {
        return uHeight;
    }

    public void setuHeight(Integer uHeight) {
        this.uHeight = uHeight;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg == null ? null : uImg.trim();
    }

    public String getuNote() {
        return uNote;
    }

    public void setuNote(String uNote) {
        this.uNote = uNote == null ? null : uNote.trim();
    }

    public Integer getuMarrage() {
        return uMarrage;
    }

    public void setuMarrage(Integer uMarrage) {
        this.uMarrage = uMarrage;
    }

    public Integer getuLike() {
        return uLike;
    }

    public void setuLike(Integer uLike) {
        this.uLike = uLike;
    }

    public Integer getuType() {
        return uType;
    }

    public void setuType(Integer uType) {
        this.uType = uType;
    }
}