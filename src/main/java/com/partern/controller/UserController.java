package com.partern.controller;

import com.partern.requestbo.CompleteUser;
import com.partern.requestbo.LoginUser;
import com.partern.responsebo.responseenitiy.ResponseEntity;
import com.partern.service.MessageService;
import com.partern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CacheConfig(cacheNames = "userCache")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    MessageService  messageService;

    @RequestMapping("/login")
    public ResponseEntity login(LoginUser user){
        return userService.login(user.getPhone(),user.getPassword());
    }

    @RequestMapping("/getUsers")
    public ResponseEntity getUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/register")
    public ResponseEntity register(CompleteUser user){
        System.out.println(user);
        return userService.register(user.toBeanUser());
    }

    @RequestMapping("/getUserById")
    @Cacheable(key = "'getUserById'+#phone")
    public ResponseEntity getUserById(String phone){
        return userService.getUserById(phone);
    }

    @RequestMapping("/getFansListById")
    @Cacheable(key = "'getFansListById'+#phone")
    public ResponseEntity getFansListById(String phone){
        return userService.getFansListById(phone);
    }

    @RequestMapping("/getConcernListById")
    @Cacheable(key = "'getConcernListById'+#phone")
    public ResponseEntity getConcernListById(String phone){
        return userService.getConcernListById(phone);
    }

    @RequestMapping("/getFansAndConcernListById")
 //   @Cacheable(key = "'getFansAndConcernListById'+#phone")
    public ResponseEntity getFansAndConcernListById(String phone){
        return userService.getFansAndConcernListById(phone);
    }

    @RequestMapping("/getChatMsg")
    @Cacheable(key = "'getChatMsg'+#id1+#id2")
    public ResponseEntity getChatMsg(String id1,String id2){
        return messageService.getLimitMessageByuIds(id1,id2,10);
    }

    @RequestMapping("/getRecommendUser")
    @Cacheable(key="'getRecommendUser'")
    public ResponseEntity getRecommendUser(){
        return userService.getRecommmendUser(24);
    }

    @RequestMapping("/searchIdOrNick")
    public ResponseEntity searchUserByIdOrNick(String searchText){
        return userService.searchUserByIdOrNick(searchText);
    }

    @RequestMapping("/updateLike")
    @CacheEvict(key="'getRecommendUser'")
    public ResponseEntity updateLike(String phone,int like){
        return userService.updateLike(phone,like);
    }
}
