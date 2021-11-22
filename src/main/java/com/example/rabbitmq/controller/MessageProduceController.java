package com.example.rabbitmq.controller;

import com.example.rabbitmq.consumer.Consumer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * <p>
 *
 * </p>
 *
 * @author mk
 * @since 2021/11/12 13:34
 */
@RestController
@RequestMapping("test")
public class MessageProduceController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Consumer consumer;

    @GetMapping("publisher/{var}")
    public void testPublisher(@PathVariable("var") String message) {
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend("myExchange", "mobi", message + "" + i);
        }
    }
}
