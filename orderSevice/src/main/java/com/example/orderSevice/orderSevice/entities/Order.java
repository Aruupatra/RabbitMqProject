package com.example.orderSevice.orderSevice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name ="orders")
@Data
public class Order {

    @Id
    private Long id;

    @JsonProperty("order_details")
    private String orderDetails;

}
