package com.partern.service;

import com.partern.bean.MyResult;
import com.partern.bean.User;
import com.partern.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public MyResult login(String uId,String uPassword) {
        User user = userMapper.login(uId,uPassword);
        System.out.println(user);
        return new MyResult(200,"success",user);
    }

    @Override
    public MyResult getUsers() {
        List<User> users = userMapper.findUsers();
        return new MyResult(200,"success",users);
    }
}
