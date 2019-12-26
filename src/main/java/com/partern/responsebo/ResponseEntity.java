package com.partern.responsebo;

import java.io.Serializable;

public class ResponseEntity implements Serializable {

    private Header header;
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public ResponseEntity(Header header, Body body) {
        this.header = header;
        this.body = body;
    }

    public ResponseEntity(){}

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
