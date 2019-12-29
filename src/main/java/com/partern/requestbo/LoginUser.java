package com.partern.requestbo;

import java.io.Serializable;

public class LoginUser implements Serializable {
    private String phone;
    private String password;
    private String validCode;

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

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public LoginUser() {
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", validCode='" + validCode + '\'' +
                '}';
    }
}
