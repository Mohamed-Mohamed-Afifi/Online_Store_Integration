package com.ecomm.payment.kafka;

import com.ecomm.payment.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentNotificationRequest {
    private String orderReference;
    private BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerName;
    String customerEmail;
}
