package com.ecomm.product.dao;

import com.ecomm.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {

    List<Product> findAllByIdInOrderById(List<Integer> purchaseIds);
}
