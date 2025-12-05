package com.ecomm.order.mapper;

import com.ecomm.order.entity.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class OrderMapper {
    public OrderLineResponse map(OrderLine orderLine){
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
