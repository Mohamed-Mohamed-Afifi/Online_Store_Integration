package com.ecomm.notification.kafka;

import com.ecomm.notification.kafka.order.Customer;
import com.ecomm.notification.kafka.payment.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderConfirmation {
    String orderRefrence;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    Customer customer;
    List<Product> products;

}
