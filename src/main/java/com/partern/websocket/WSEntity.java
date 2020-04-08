package com.partern.websocket;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

public class WSEntity implements Serializable {
    private String type;
    private String from;
    private String to;
    private String time;
    private Object payload;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public WSEntity() { }

    @Override
    public String toString() {
        return "WSEntity{" +
                "type='" + type + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", time='" + time + '\'' +
                ", payload=" + payload +
                '}';
    }
}
