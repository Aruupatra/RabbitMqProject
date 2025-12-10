package com.example.orderSevice.orderSevice.components;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String EXCHANGE="order.exchange";
    public static final String QueueName="notification.queue";
    public static final String RoutingKey="order.create";

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue notificationQueue()
    {
        return QueueBuilder.durable(QueueName).build();
    }

    @Bean
    public Binding binding(Queue notificationQueue,DirectExchange orderExchange){
        return BindingBuilder.bind(notificationQueue).to(orderExchange).with(RoutingKey);
    }
}
