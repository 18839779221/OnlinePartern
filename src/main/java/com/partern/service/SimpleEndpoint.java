package com.partern.service;

import com.partern.utils.Log;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

//开启Spring管理
@Component
//表示发送消息端点
@ServerEndpoint("/endpoint")
public class SimpleEndpoint {

    /**
     * 线程安全基本数据
     */
    private static AtomicInteger COUNT = new AtomicInteger();

    /**
     * 在线用户实例
     */
    private static CopyOnWriteArraySet<SimpleEndpoint> container = new CopyOnWriteArraySet<SimpleEndpoint>();

    /**
     * 当前用户Session
     */
    private Session session;

    //获取连接时调用
    @OnOpen
    public void onOpen (Session session) {
        this.session = session;
        container.add(this);
        addUser();
    }

    //连接关闭时调用
    @OnClose
    public void onClose () {
        //从容器中删除用户
        container.remove(this);
        //减去用户数量
        subUser();
    }

    //接受WebSocket发送的消息
    @OnMessage
    public void onMessage (String message, Session session) {
        Log.info("Send all user: "+ message);
        container.forEach(target -> target.sendMessage(message));
    }

    //发生错误时调用
    @OnError
    public void onError (Session session, Throwable error) {
        Log.info("error: "+ error.getMessage());
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
     * 自定义发送消息给全部用户
     * @param message
     */
    public static void sendUsers (String message) {
        Log.info("Send all user: "+ message);
        container.forEach(target -> target.sendMessage(message));
    }

    /**
     * 添加用户数量
     */
    public void addUser () {
        SimpleEndpoint.COUNT.addAndGet(1);
        Log.info("Add user: "+ COUNT.get());
    }

    /**
     * 减去用户数量
     */
    public void subUser () {
        SimpleEndpoint.COUNT.addAndGet(-1);
        Log.info("Sub user: "+ COUNT.get());
    }
}