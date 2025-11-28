package com.ecomm.customer.dao;

import com.ecomm.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
