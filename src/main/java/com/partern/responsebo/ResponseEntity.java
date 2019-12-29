package com.partern.responsebo;

import com.partern.utils.ResponseEnum;

import java.io.Serializable;
import java.util.Date;

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

    /**
     * 简单通用的成功返回体，若无需特别说明即可使用此返回体
     * @param bodyData  返回内容
     * @return  响应实体
     */
    public static ResponseEntity getPublicSuccessResponse(Object bodyData){
        Header header = new Header();
        header.setType(ResponseEnum.SUCCESS);
        header.setTimestamp(new Date().getTime()+"");
        Body body = new Body(bodyData);
        return new ResponseEntity(header,body);
    }

    /**
     * 简单通用的失败返回体，若无需特别说明即可使用此返回体
     * @param bodyData  返回内容
     * @return  响应实体
     */
    public static ResponseEntity getPublicFailResponse(Object bodyData){
        Header header = new Header();
        header.setType(ResponseEnum.FAILURE);
        header.setTimestamp(new Date().getTime()+"");
        Body body = new Body(bodyData);
        return new ResponseEntity(header,body);
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
