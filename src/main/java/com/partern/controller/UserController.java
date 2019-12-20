package com.partern.controller;

import com.partern.bean.MyResult;
import com.partern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={"http://127.0.0.1:3000"})
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public MyResult login(String username,String password){
        return userService.login(username,password);
    }
}
