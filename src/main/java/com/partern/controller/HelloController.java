package com.partern.controller;

import com.partern.bean.User;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.partern.responsebo.responseenitiy.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;

@RestController
public class HelloController {

    @RequestMapping("/")
    public ResponseEntity hello(){
        return ResponseEntity.getPublicSuccessResponse(null);
    }
}
