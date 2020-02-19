package com.partern.service;

import com.partern.bean.Message;
import com.partern.mapper.MessageMapper;
import com.partern.mapper.UserMapper;
import com.partern.responsebo.responseenitiy.ResponseEntity;
import com.partern.responsebo.responsemsg.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertMessage(Message message) {
        return messageMapper.insert(message);
    }

    /**
     * 获取id1和id2的最新聊天记录,获取limit条
     * @param id1
     * @param id2
     * @return
     */
    @Override
    public ResponseEntity getLimitMessageByuIds(String id1, String id2, int limit) {
        List<Message> messages = messageMapper.getLimitMessageByuIds(id1, id2,limit);
        //此时获取到的消息为倒序，先将List反转
        Collections.reverse(messages);
        //id2为对方id
        String nick = userMapper.getNickByuId(id2);
        System.out.println(new ResponseMsg(id2,nick,messages));
        return ResponseEntity.getPublicQueryResponse(new ResponseMsg(id2,nick,messages));
    }

}
