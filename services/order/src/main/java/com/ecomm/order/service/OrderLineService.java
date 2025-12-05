package com.ecomm.order.service;

import com.ecomm.order.dao.OrderLineRepo;
import com.ecomm.order.entity.OrderLine;
import com.ecomm.order.mapper.OrderLineResponse;
import com.ecomm.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepo orderLineRepo;
    private final OrderMapper orderMapper;
    public OrderLine createOrderLine(OrderLine orderLine){
        return orderLineRepo.save(orderLine);
    }

    public List<OrderLineResponse> findAllByOrderId(Integer id) {

        return orderLineRepo.findAllByOrderId(id).stream().map(orderMapper::map).toList();
    }
}
