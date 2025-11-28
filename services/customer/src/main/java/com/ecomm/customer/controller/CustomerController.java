package com.ecomm.customer.controller;

import com.ecomm.customer.dto.CustomerDto;
import com.ecomm.customer.entity.Customer;
import com.ecomm.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDto));
    }
}
