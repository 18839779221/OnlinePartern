package com.partern.controller;

import com.partern.bean.User;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "main";
    }
}
