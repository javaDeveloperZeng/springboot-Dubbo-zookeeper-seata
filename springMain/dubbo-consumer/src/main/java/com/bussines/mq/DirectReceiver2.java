package com.bussines.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver2 {
    @RabbitHandler
    public void process(Object testMessage) {
        System.out.println("DirectReceiver消费者收到消息---2  : " + testMessage.toString());
    }
}
