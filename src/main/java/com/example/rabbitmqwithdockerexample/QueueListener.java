package com.example.rabbitmqwithdockerexample;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class QueueListener {

    @RabbitListener(queues = "CodingInTime-Queue")
    public void handleMessage(String notification) {
        System.out.println("Kuyruktan Gelen Mesaj:" + notification);
    }
}