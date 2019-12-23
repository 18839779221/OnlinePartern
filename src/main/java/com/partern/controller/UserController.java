package com.partern.controller;

import com.partern.bean.MyResult;
import com.partern.bean.User;
import com.partern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public MyResult login(String username,String password){
        return userService.login(username,password);
    }

    @RequestMapping("/getUsers")
    public MyResult getUsers(){
        return userService.getUsers();
    }

}
