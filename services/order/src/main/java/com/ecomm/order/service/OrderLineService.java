package com.ecomm.order.service;

import com.ecomm.order.dao.OrderLineRepo;
import com.ecomm.order.entity.OrderLine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepo orderLineRepo;

    public OrderLine createOrderLine(OrderLine orderLine){
        return orderLineRepo.save(orderLine);
    }
}
