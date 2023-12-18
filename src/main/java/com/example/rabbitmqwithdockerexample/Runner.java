package com.example.rabbitmqwithdockerexample;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Runner implements CommandLineRunner {

    static String exchangeName = "CodingInTime-Exchange";
    static String routingName = "CodingInTime-Routing";

    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    rabbitTemplate.convertAndSend(exchangeName, routingName, "\nMerhaba RabbitMQ! Tarih : " + new Date());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}