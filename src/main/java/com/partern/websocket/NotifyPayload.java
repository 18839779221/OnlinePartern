package com.partern.websocket;

import java.io.Serializable;

//通知消息内容
public class NotifyPayload implements Serializable,Payload {

    private Object object;

    public NotifyPayload(Object object){
        this.object = object;
    }

    public NotifyPayload(){}

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "NotifyPayload{" +
                "object=" + object +
                '}';
    }
}
