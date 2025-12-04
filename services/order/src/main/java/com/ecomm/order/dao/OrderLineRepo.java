package com.ecomm.order.dao;

import com.ecomm.order.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepo extends JpaRepository<OrderLine,Integer> {
}
