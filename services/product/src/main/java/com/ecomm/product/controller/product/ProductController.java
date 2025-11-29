package com.ecomm.product.controller.product;

import com.ecomm.product.entity.Product;
import com.ecomm.product.service.product.ProductPurchaseRequest;
import com.ecomm.product.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProdcut(@PathVariable Integer id){
        return ResponseEntity.ok(productService.getProduct(id));
    }
    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseProducts(@RequestBody List<ProductPurchaseRequest> productPurchaseRequests){
        return ResponseEntity.ok(productService.purchaseProducts(productPurchaseRequests));
    }
    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
