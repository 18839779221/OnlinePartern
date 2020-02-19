package com.partern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParternApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testSend() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","第一条消息");
        map.put("data", Arrays.asList("hello",true,"中"));
        rabbitTemplate.convertAndSend("hello",map);
    }


    @Test
    public void receiveSend(){
        Object o = rabbitTemplate.receiveAndConvert("hello");
        System.out.println(o.getClass());
        System.out.println(o);
    }


    public ParternApplicationTests(){}

}
