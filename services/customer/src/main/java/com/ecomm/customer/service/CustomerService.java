package com.ecomm.customer.service;

import com.ecomm.customer.dao.CustomerRepo;
import com.ecomm.customer.dto.CustomerDto;
import com.ecomm.customer.entity.Customer;
import com.ecomm.customer.handlers.CustomerNotFoundException;
import jakarta.validation.Valid;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    public Customer createCustomer(@Valid CustomerDto customerDto) {
        Customer customer=new Customer();
        customer.setName(customerDto.getName());
        customer.setAge(customerDto.getAge());
        customer.setEmail(customerDto.getEmail());
        return customerRepo.save(customer);
    }
    public Customer updateCustomer(Customer customer){
        Customer customer1;
        if(customerRepo.existsById(customer.getId())){
             customer1=customerRepo.findById(customer.getId()).get();
            if(StringUtils.isNotBlank(customer.getName())){
                customer1.setName(customer.getName());
            }
            if(StringUtils.isNotBlank(customer.getAge())){
                customer1.setAge(customer.getAge());
            }
            if(StringUtils.isNotBlank(customer.getEmail())){
                customer1.setEmail(customer.getEmail());
            }
        }else {
            throw new CustomerNotFoundException("customer doesn't exist ");
        }
        return customerRepo.save(customer1);
    }

    public void deleteCustomer(Integer id) {
        if(customerRepo.findById(id).isPresent()){
            customerRepo.deleteById(id);
        }
        else{
            throw new CustomerNotFoundException("cusomter not found");
        }
    }

    public Customer getCustomerById(Integer id) {
        if(!customerRepo.existsById(id)){
            throw new CustomerNotFoundException("customer not found");
        }
        return customerRepo.findById(id).get();
    }

    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }
}
