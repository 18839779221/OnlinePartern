package com.atguigu.springnoot.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "active")
public class Active {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String activeEvent;
    private Date activeTime;
    private String activeLocation;

//    public Active(Integer id, String activeEvent, Date activeTime, String activeLocation) { Date  是自己new 一个
   /* public Active(Integer id, String activeEvent, String activeLocation) {
        this.id = id;
        this.activeEvent = activeEvent;
        this.activeTime = new Date();
        this.activeLocation = activeLocation;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActiveEvent() {
        return activeEvent;
    }

    public void setActiveEvent(String activeEvent) {
        this.activeEvent = activeEvent;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public String getActiveLocation() {
        return activeLocation;
    }

    public void setActiveLocation(String activeLocation) {
        this.activeLocation = activeLocation;
    }
}
