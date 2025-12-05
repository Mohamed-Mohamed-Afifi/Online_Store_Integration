package com.ecomm.order.clients.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {
    @GetMapping("/{customer_id}")
     Optional<CustomerResponse> findCustomerById(@PathVariable ("customer_id") Integer customer_id);
}
