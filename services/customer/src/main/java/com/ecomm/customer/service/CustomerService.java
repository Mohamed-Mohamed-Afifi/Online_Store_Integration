package com.ecomm.customer.service;

import com.ecomm.customer.dao.CustomerRepo;
import com.ecomm.customer.dto.CustomerDto;
import com.ecomm.customer.entity.Customer;
import com.ecomm.customer.handlers.CustomerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    public Customer createCustomer(@Valid CustomerDto customerDto) {
        Customer customer=new Customer();
        customer.setName(customerDto.getName());
        customer.setAge(customer.getAge());
        customer.setEmail(customerDto.getEmail());
        return customerRepo.save(customer);
    }
    public Customer updateCustomer(Customer customer){
        if(customerRepo.existsById(customer.getId())){
            Customer customer1=customerRepo.findById(customer.getId()).get();
        }else {
            throw new CustomerNotFoundException("customer doesn't exist ");
        }
    }
}
