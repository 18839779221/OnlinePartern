package com.partern.controller;

import com.partern.responsebo.responseenitiy.ResponseEntity;
import com.partern.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/getlimitmsg")
    public ResponseEntity getLimitMsg(@RequestParam("id1") String id1,@RequestParam("id2") String id2){
        return messageService.getLimitMessageByuIds(id1,id2,10);
    }
}
