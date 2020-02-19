package com.partern.service;

import com.partern.bean.Message;
import com.partern.responsebo.responseenitiy.ResponseEntity;

public interface MessageService {
    int insertMessage(Message message);

    ResponseEntity getLimitMessageByuIds(String id1, String id2, int limit);

}
