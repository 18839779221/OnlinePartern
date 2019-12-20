package com.partern.service;

import com.partern.bean.MyResult;

public interface UserService {

    MyResult login(String uId,String uPassword);
}
