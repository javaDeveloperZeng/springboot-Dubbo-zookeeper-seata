package com.bussines.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMessage {
    @RabbitListener(queues="TestDirectQueue")
   public void receive(Object object){
        System.out.println(object);
    }
}
