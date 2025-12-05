package com.ecomm.order.controller.orderline;

import com.ecomm.order.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orderlines")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService orderLineService;
    public ResponseEntity<?> findAllByOrderId(@PathVariable Integer id){
        return ResponseEntity.ok(orderLineService.findAllByOrderId(id));
    }
}
