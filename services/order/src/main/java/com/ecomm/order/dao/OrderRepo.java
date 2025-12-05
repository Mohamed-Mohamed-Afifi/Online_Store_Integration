package com.ecomm.order.dao;


import com.ecomm.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {
}
