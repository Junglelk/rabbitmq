package com.example.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Description:
 * <p>
 *
 * </p>
 *
 * @author mk
 * @since 2021/11/12 9:29
 */
@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void produce() {
        while (true) {
            String date = new Date() + " beijing";
            System.out.println("消息：" + date);
            rabbitTemplate.convertAndSend("myExchange","mobi",date);
        }
    }
}
