package com.example.orderSevice.orderSevice.services;

import com.example.orderSevice.orderSevice.components.RabbitMqConfig;
import com.example.orderSevice.orderSevice.dtos.OrderRequestDto;
import com.example.orderSevice.orderSevice.dtos.OrderResponseDto;
import com.example.orderSevice.orderSevice.entities.Order;
import com.example.orderSevice.orderSevice.repositories.OrderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private RabbitTemplate rabbitTemplate;
    OrderService(OrderRepository orderRepository,RabbitTemplate rabbitTemplate)
    {
        this.orderRepository=orderRepository;
        this.rabbitTemplate=rabbitTemplate;
    }
    public OrderResponseDto save(OrderRequestDto orderRequestDto)
    {
     Order order=toEnitity(orderRequestDto);

     order=orderRepository.save(order);
     rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.RoutingKey,order);
     OrderResponseDto orderResponseDto=toResoponse(order);
     return orderResponseDto;
    }

    public OrderResponseDto toResoponse(Order order){
        OrderResponseDto orderResponseDto=new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDetails(order.getOrderDetails());

        return orderResponseDto;
    }

    public Order toEnitity(OrderRequestDto orderRequestDto){
        Order order=new Order();
        order.setId(orderRequestDto.getId());
        order.setOrderDetails(orderRequestDto.getOrderDetails());

        return order;
    }
}
