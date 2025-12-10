package com.example.notificationSevice.notificationSevice.components;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabboitMqConfig {

    public static final String EXCHANGE="order.exchange";
    public static final String QueueName="notification.queue";
    public static final String RoutingKey="order.create";

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(EXCHANGE);
    }
    @Bean
    public Queue createQueue(){
        return QueueBuilder.durable(QueueName).build();
    }
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(RoutingKey);
    }
}
