package com.partern.requestbo;

import com.partern.bean.User;

public class CompleteUser {

    private String phone;     //手机号
    private String password;  //密码
    private String nick;      //昵称
    private int age;          //年龄
    private int sex;          //性别
    private String prof;      //职业
    private int educate;      //学历
    private int income;       //收入
    private String addr;      //地址
    private int height;       //身高
    private String img;       //图片地址
    private String note;      //个性签名
    private int marrage;      //婚姻状况
    private int like;         //点赞数
    private int type;         //用户类型

    public CompleteUser() {}

    @Override
    public String toString() {
        return "CompleteUser{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", nick='" + nick + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", prof='" + prof + '\'' +
                ", educate=" + educate +
                ", income=" + income +
                ", addr='" + addr + '\'' +
                ", height=" + height +
                ", img='" + img + '\'' +
                ", note='" + note + '\'' +
                ", marrage=" + marrage +
                ", like=" + like +
                ", type=" + type +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public int getEducate() {
        return educate;
    }

    public void setEducate(int educate) {
        this.educate = educate;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMarrage() {
        return marrage;
    }

    public void setMarrage(int marrage) {
        this.marrage = marrage;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User toBeanUser() {
        User user = new User();
        user.setU_id(phone);
        user.setU_password(password);
        user.setU_nick(nick);
        user.setU_educate(educate);
        user.setU_income(income);
        user.setU_addr(addr);
        user.setU_note(note);
        user.setU_marrage(marrage);
        user.setU_age(age);
        user.setU_sex(sex);
        user.setU_prof(prof);
        user.setU_img(img);
        user.setU_height(height);
        user.setU_like(like);
        user.setU_type(type);
        return user;
    }

}
