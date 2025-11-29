package com.ecomm.product.dao;

import com.ecomm.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatergoryRepo extends JpaRepository<Category,Integer> {
}
