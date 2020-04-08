package com.partern.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Active implements Serializable {
    private Integer id;

    private String active_event;

    private String active_time;

    private String active_location;

    public Active(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActive_event() {
        return active_event;
    }

    public void setActive_event(String active_event) {
        this.active_event = active_event;
    }

    public String getActive_time() {
        return active_time;
    }

    public void setActive_time(String active_time) {
        this.active_time = active_time;
    }

    public String getActive_location() {
        return active_location;
    }

    public void setActive_location(String active_location) {
        this.active_location = active_location;
    }

    @Override
    public String toString() {
        return "Active{" +
                "id=" + id +
                ", active_event='" + active_event + '\'' +
                ", active_time=" + active_time +
                ", active_location='" + active_location + '\'' +
                '}';
    }
}