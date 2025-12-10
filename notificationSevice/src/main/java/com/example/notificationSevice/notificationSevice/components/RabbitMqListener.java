package com.example.notificationSevice.notificationSevice.components;

import com.example.notificationSevice.notificationSevice.Models.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {


    @RabbitListener(queues = RabboitMqConfig.QueueName)
    public void handelOrderCreated(Order order){

        System.out.println("order received");
    }
}
