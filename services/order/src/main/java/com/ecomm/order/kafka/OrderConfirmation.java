package com.ecomm.order.kafka;

import com.ecomm.order.clients.customer.CustomerResponse;
import com.ecomm.order.clients.product.PurchaseResponse;
import com.ecomm.order.entity.PaymentMethod;
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
    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private CustomerResponse customerResponse;
    List<PurchaseResponse> products;

}
