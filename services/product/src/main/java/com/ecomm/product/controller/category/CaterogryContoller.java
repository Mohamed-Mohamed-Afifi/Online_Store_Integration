package com.ecomm.product.controller.category;

import com.ecomm.product.entity.Category;
import com.ecomm.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CaterogryContoller {
    @Autowired
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
    @GetMapping
    public ResponseEntity<?> getAllCategory(){
        return ResponseEntity.ok(categoryService.findAllCategory());
    }
}
