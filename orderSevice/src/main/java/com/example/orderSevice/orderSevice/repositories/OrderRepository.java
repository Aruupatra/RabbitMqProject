package com.example.orderSevice.orderSevice.repositories;

import com.example.orderSevice.orderSevice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
