package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Description:
 * <p>
 *
 * </p>
 *
 * @author mk
 * @since 2021/11/12 10:33
 */
@Component
public class Consumer {

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"), key = "mobi", exchange = @Exchange("myExchange")))
    public void process(String message) {
        System.out.println(message + new Date());
    }
}
