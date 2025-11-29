package com.ecomm.product.service.category;

import com.ecomm.product.dao.CatergoryRepo;
import com.ecomm.product.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CatergoryRepo catergoryRepo;
    public Category createCategory(Category category){
        return catergoryRepo.save(category);
    }
    public List<Category> findAllCategory(){
        return catergoryRepo.findAll();
    }
    public Category findCaterory(Integer id){
        return catergoryRepo.findById(id).get();
    }
}
