package com.partern.responsebo;

import java.io.Serializable;

public class Body implements Serializable {
    private Object data;

    public Body(){}

    public Body(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Body{" +
                "data=" + data +
                '}';
    }
}
