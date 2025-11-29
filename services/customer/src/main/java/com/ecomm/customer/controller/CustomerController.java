package com.ecomm.customer.controller;

import com.ecomm.customer.dto.CustomerDto;
import com.ecomm.customer.entity.Customer;
import com.ecomm.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDto));
    }
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.updateCustomer(customer));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @GetMapping
    public ResponseEntity<?> getAllCutomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}
