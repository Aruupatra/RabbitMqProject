package com.example.orderSevice.orderSevice.services;

import com.example.orderSevice.orderSevice.dtos.OrderRequestDto;
import com.example.orderSevice.orderSevice.dtos.OrderResponseDto;
import com.example.orderSevice.orderSevice.entities.Order;
import com.example.orderSevice.orderSevice.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    OrderService(OrderRepository orderRepository)
    {
        this.orderRepository=orderRepository;
    }
    public OrderResponseDto save(OrderRequestDto orderRequestDto)
    {
     Order order=toEnitity(orderRequestDto);

     order=orderRepository.save(order);
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
