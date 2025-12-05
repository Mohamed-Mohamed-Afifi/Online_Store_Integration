package com.ecomm.order.clients.payment;

import com.ecomm.order.entity.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private Integer id;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
    private Integer orderId;
}
