package com.example.orderSevice.orderSevice.controllers;


import com.example.orderSevice.orderSevice.dtos.OrderRequestDto;
import com.example.orderSevice.orderSevice.dtos.OrderResponseDto;
import com.example.orderSevice.orderSevice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private OrderService orderService;
    OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping
    public ResponseEntity raiseOrder(@RequestBody OrderRequestDto orderRequestDto){

        OrderResponseDto orderResponseDto=orderService.save(orderRequestDto);

        return new ResponseEntity<>(orderResponseDto,HttpStatus.OK);


    }
}
