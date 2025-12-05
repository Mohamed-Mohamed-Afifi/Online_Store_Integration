package com.ecomm.order.dao;

import com.ecomm.order.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepo extends JpaRepository<OrderLine,Integer> {
    List<OrderLine> findAllByOrderId(Integer id);
}
