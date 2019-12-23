package com.partern.service;

import com.partern.bean.MyResult;
import com.partern.bean.User;
import java.util.List;

public interface UserService {

    MyResult login(String uId,String uPassword);

    MyResult getUsers();
}
