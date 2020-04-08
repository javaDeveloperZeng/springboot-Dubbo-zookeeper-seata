package com.bussines.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {
    //创建队列 起名：TestDirectQueue
    @Bean
    public Queue TestDirecQueue(){
        return new Queue("TestDirectQueue",true);
    }
    //Direct交换机 起名：TestDirectExchange
    @Bean
    public DirectExchange TestDirctExchange(){
        return new DirectExchange("TestDirectExchange");
    }
    //绑定 将队列和交换机绑定，并设置用于匹配键：TestDirectRouting
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(TestDirecQueue()).to(TestDirctExchange()).with("TestDirectRouting");
    }
}
