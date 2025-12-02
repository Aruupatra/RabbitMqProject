package com.example.orderSevice.orderSevice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderRequestDto {

    private Long id;

    @JsonProperty("order_details")
    private String orderDetails;
}
