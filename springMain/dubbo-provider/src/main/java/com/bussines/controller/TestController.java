package com.bussines.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {
    @Autowired
    AmqpAdmin amqpAdmin;
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * https://blog.csdn.net/qq_35387940/article/details/100514134
     */
    @Test
    public void creatTopic(){
        Exchange exchange=new DirectExchange("directExchange");
        amqpAdmin.declareExchange(exchange);
        Queue testDirectQueue = new Queue("TestDirectQueue", true);
        amqpAdmin.declareQueue(testDirectQueue);
        Binding binding = new Binding("TestDirectQueue", Binding.DestinationType.QUEUE, "directExchange","routingKey", null);
        amqpAdmin.declareBinding(binding);

        Exchange exchange2=new FanoutExchange("directExchange");
    }

    @Test
    public void sendMessage() throws Exception{
        for(int i=0;i<10;i++){
            Map map=new HashMap<>();
            map.put("name","第"+i+"个消息");
            map.put("content","消息内容"+i);
            rabbitTemplate.convertAndSend("directExchange","routingKey", (Object) map);
        }

    }
    @Test
    public void getMessage(){
       Object object= rabbitTemplate.receive("TestDirectQueue");
        System.out.println(object);
    }
}
