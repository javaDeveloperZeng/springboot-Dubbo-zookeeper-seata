package com.bussines.configure;/**
 * @title: RabbitTemplateConfig
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/4/2713:37
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 *@Description TODO 通过实现ConfirmCallBack接口，消息发送到交换器Exchange后触发回调。
 *@Author ZLS
 *  使用该功能需要开启确认，spring-boot中配置如下：
 * spring.rabbitmq.publisher-confirms = true
 *@Date 2020/4/27 13:37
 **/
/*@Component*/
@Slf4j
public class RabbitTemplateConfig implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("消息唯一标识："+correlationData);
        log.info("确认结果："+ack);
        log.info("失败原因："+cause);
    }
}
