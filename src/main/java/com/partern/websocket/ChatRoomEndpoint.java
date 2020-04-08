package com.partern.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.partern.bean.Message;
import com.partern.service.MessageService;
import com.partern.utils.DateFormat;
import com.partern.utils.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//开启Spring管理
@Component
//表示发送消息端点
@ServerEndpoint("/chat")
@Slf4j
public class ChatRoomEndpoint {


    /**
     * 线程安全基本数据
     */
    private static AtomicInteger COUNT = new AtomicInteger();

    /**
     * 在线用户实例
     */
    private static ConcurrentHashMap<String,ChatRoomEndpoint> container = new ConcurrentHashMap <String,ChatRoomEndpoint>();

    /**
     * 缓存的消息（接收者暂时未上线）
     */
    private static ConcurrentHashMap<String,List<WSEntity>> cacheMsgMap = new ConcurrentHashMap<>();

    /**
     * 当前用户Session
     */
    private Session session;

    private static MessageService messageService;

    private String id;

    public Session getSession() {
        return session;
    }

    @Autowired
    public void setMessageService(MessageService msgService){
        messageService = msgService;
    }

    //获取连接时调用
    @OnOpen
    public void onOpen (Session session) {
        this.session = session;
        id = session.getQueryString();
        //testNotify(id);
        checkUnreceivedMsg(id);
        container.put(id,this);
        addUser();
    }

    public void testNotify(String id){
        List<WSEntity> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            WSEntity wsEntity = new WSEntity();
            wsEntity.setTo(id);
            wsEntity.setPayload(new MsgPayload("hello"+i,"sas"+i));
            wsEntity.setType(MsgType.PRIVATEMSG);
            list.add(wsEntity);
        }
        WSEntity entity = new WSEntity();
        entity.setType(MsgType.NOTIFY_HISTORY_MSG);
        entity.setTo(id);
        entity.setPayload(new NotifyPayload(list));
        entity.setTime(DateFormat.format(new Date()));
        sendMessage(entity);
    }

    //连接关闭时调用
    @OnClose
    public void onClose () {
        //从容器中删除用户
        if(container.containsKey(id)){
            container.remove(id);
        }
        //减去用户数量
        subUser();
    }

    //接受WebSocket发送的消息
    @OnMessage
    public void onMessage (String message, Session session) {
        log.info("Recevice Message: "+ message);
//        WSEntity entity = JSON.parseObject(message,WSEntity.class);
        WSEntity entity = parseMessage(message);
        parseMessage(message);
        switch (entity.getType()){
            case MsgType.GROUPMSG:
                sendGroupMsg(entity);
                break;
            case MsgType.PRIVATEMSG:
                sendPrivateMsg(entity);
                break;
        }
//        container.forEach(target -> target.sendMessage(message));
    }

    private WSEntity parseMessage(String message) {
        JSONObject jsonObject = JSON.parseObject(message);
        WSEntity entity = new WSEntity();
        entity.setTime(jsonObject.getString("time"));
        entity.setTo(jsonObject.getString("to"));
        entity.setFrom(jsonObject.getString("from"));
        entity.setType(jsonObject.getString("type"));
        JSONObject jPayload = jsonObject.getJSONObject("payload");
        if(entity.getType()==MsgType.NOTIFY_HISTORY_MSG){
            entity.setPayload(new NotifyPayload(jPayload.get("object")));
        }else{
            entity.setPayload(new MsgPayload(jPayload.getString("msg"),jPayload.getString("nick")));
        }
        return entity;
    }

    private void sendGroupMsg(WSEntity entity) {
        container.values().forEach(target -> target.sendMessage(entity));
    }

    private void sendPrivateMsg(WSEntity entity) {
        //如果对方在线
        log.info(container.toString());
        if(container.containsKey(entity.getTo())){
            container.get(entity.getTo()).sendMessage(entity);
            System.out.println(container.get(entity.getTo()).session.getQueryString());
        }else{
            sendToMessageQueue(entity);
        }
        save(entity);
    }

    //将对方不在线的消息暂时缓存起来
    private void sendToMessageQueue(WSEntity entity) {
        List list = null;
        if(!cacheMsgMap.containsKey(entity.getTo())){
            list = new ArrayList();
        }else{
            list = cacheMsgMap.get(entity.getTo());
        }
        list.add(entity);
        cacheMsgMap.put(entity.getTo(),list);
    }

    //当有新客户端连接时，检查其是否有未接收的消息
    private void checkUnreceivedMsg(String id) {
        if(cacheMsgMap.containsKey(id)){
            notifyUser(cacheMsgMap.get(id),id);
        }
    }

    private void notifyUser(List<WSEntity> wsEntities, String id) {
        WSEntity entity = new WSEntity();
        entity.setType(MsgType.NOTIFY_HISTORY_MSG);
        entity.setTo(id);
        entity.setPayload(new NotifyPayload(wsEntities));
        entity.setTime(DateFormat.format(new Date()));
        sendMessage(entity);

    }


    //将聊天信息保存到数据库
    private void save(WSEntity entity) {
        messageService.insertMessage(new Message(entity));
    }

    //发生错误时调用
    @OnError
    public void onError (Session session, Throwable error) {
        log.info("error: "+ error);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage (String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息
     * @param message   WSEntity实体类
     */
    public void sendMessage (WSEntity message) {
        try {
            this.session.getBasicRemote().sendText(JSON.toJSONString(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义发送消息给全部用户
     * @param message
     */
    public static void sendUsers (String message) {
        log.info("Send all user: "+ message);
//        container.forEach(target -> target.sendMessage(message));
    }

    /**
     * 添加用户数量
     */
    public void addUser () {
        ChatRoomEndpoint.COUNT.addAndGet(1);
        log.info("Add user: "+ COUNT.get());
    }

    /**
     * 减去用户数量
     */
    public void subUser () {
        ChatRoomEndpoint.COUNT.addAndGet(-1);
        log.info("Sub user: "+ COUNT.get());
    }


}