package com.partern.controller;

import com.partern.bean.User;
import com.partern.requestbo.CompleteUser;
import com.partern.responsebo.ResponseEntity;
import com.partern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ResponseEntity login(String username, String password){
        return userService.login(username,password);
    }

    @RequestMapping("/getUsers")
    public ResponseEntity getUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/register")
    public ResponseEntity register(CompleteUser user){
        return userService.register(user.toBeanUser());
    }

    @RequestMapping("/getUserById")
    public ResponseEntity getUserById(String phone){
        return userService.getUserById(phone);
    }

}
