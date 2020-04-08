package com.partern.responsebo;

import com.partern.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ResponseUser implements Serializable {
    private String phone;     //手机号
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
    private int count_fans;   //粉丝数
    private int count_concern;//关注人数

    String headImgPrefix = "op";
    String headImgPath = "http://localhost:8080/api/upload";

    public ResponseUser(User user,int count_concern,int count_fans){
        if(user == null) return;
        phone = user.getU_id();
        nick = user.getU_nick();
        age = user.getU_age();
        sex = user.getU_sex();
        prof = user.getU_prof();
        educate = user.getU_educate();
        income = user.getU_income();
        addr = user.getU_addr();
        height = user.getU_height();
        note = user.getU_note();
        marrage = user.getU_marrage();
        like = user.getU_like();
        this.count_fans = count_fans;
        this.count_concern = count_concern;
        setImg(user.getU_img());


    }

    public ResponseUser(){ }

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
        if(img.startsWith(headImgPrefix)){
            this.img = headImgPath + "/" + img;
            return ;
        }
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

    public int getCount_fans() {
        return count_fans;
    }

    public void setCount_fans(int count_fans) {
        this.count_fans = count_fans;
    }

    public int getCount_concern() {
        return count_concern;
    }

    public void setCount_concern(int count_concern) {
        this.count_concern = count_concern;
    }

    @Override
    public String toString() {
        return "ResponseUser{" +
                "phone='" + phone + '\'' +
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
                ", count_fans=" + count_fans +
                ", count_concern=" + count_concern +
                '}';
    }
}
