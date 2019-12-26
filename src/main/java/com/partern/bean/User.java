package com.partern.bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String u_id;     //手机号
    private String u_password;  //密码
    private String u_nick;      //昵称
    private int u_age;          //年龄
    private int u_sex;          //性别
    private String u_prof;      //职业
    private int u_educate;      //学历
    private int u_income;       //收入
    private String u_addr;      //地址
    private int u_height;       //身高
    private String u_img;       //图片地址
    private String u_note;      //个性签名
    private int u_marrage;      //婚姻状况
    private int u_like;         //点赞数
    private int u_type;         //用户类型

    public User() {
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_nick() {
        return u_nick;
    }

    public void setU_nick(String u_nick) {
        this.u_nick = u_nick;
    }

    public int getU_age() {
        return u_age;
    }

    public void setU_age(int u_age) {
        this.u_age = u_age;
    }

    public int getU_sex() {
        return u_sex;
    }

    public void setU_sex(int u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_prof() {
        return u_prof;
    }

    public void setU_prof(String u_prof) {
        this.u_prof = u_prof;
    }

    public int getU_educate() {
        return u_educate;
    }

    public void setU_educate(int u_educate) {
        this.u_educate = u_educate;
    }

    public int getU_income() {
        return u_income;
    }

    public void setU_income(int u_income) {
        this.u_income = u_income;
    }

    public String getU_addr() {
        return u_addr;
    }

    public void setU_addr(String u_addr) {
        this.u_addr = u_addr;
    }

    public int getU_height() {
        return u_height;
    }

    public void setU_height(int u_height) {
        this.u_height = u_height;
    }

    public String getU_img() {
        return u_img;
    }

    public void setU_img(String u_img) {
        this.u_img = u_img;
    }

    public String getU_note() {
        return u_note;
    }

    public void setU_note(String u_note) {
        this.u_note = u_note;
    }

    public int getU_marrage() {
        return u_marrage;
    }

    public void setU_marrage(int u_marrage) {
        this.u_marrage = u_marrage;
    }

    public int getU_like() {
        return u_like;
    }

    public void setU_like(int u_like) {
        this.u_like = u_like;
    }

    public int getU_type() {
        return u_type;
    }

    public void setU_type(int u_type) {
        this.u_type = u_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_nick='" + u_nick + '\'' +
                ", u_age=" + u_age +
                ", u_sex=" + u_sex +
                ", u_prof='" + u_prof + '\'' +
                ", u_educate=" + u_educate +
                ", u_income=" + u_income +
                ", u_addr='" + u_addr + '\'' +
                ", u_height=" + u_height +
                ", u_img='" + u_img + '\'' +
                ", u_note='" + u_note + '\'' +
                ", u_marrage=" + u_marrage +
                ", u_like=" + u_like +
                ", u_type=" + u_type +
                '}';
    }

   public static List<User> noPassword(List<User> users){
       for (User user: users) {
           user.setU_password("");
       }
       return users;
   }

   public static User noPassword(User user){
        user.setU_password("");
        return user;
   }
}