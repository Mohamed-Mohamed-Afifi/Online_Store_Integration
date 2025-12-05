package com.ecomm.order.clients.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {
    @PostMapping
    PaymentResponse requestOrderPayment(@RequestBody PaymentRequest paymentRequest);
}
