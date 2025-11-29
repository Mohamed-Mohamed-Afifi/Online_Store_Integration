package com.ecomm.product.service.product;


import com.ecomm.product.dao.ProductRepo;
import com.ecomm.product.dto.ProductDto;
import com.ecomm.product.entity.Product;
import com.ecomm.product.handler.ProductNotAvaible;
import com.ecomm.product.handler.ProductNotFound;
//import com.ecomm.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
//    private ProductMapper productMapper;
    public Product createProduct(Product product){
        return productRepo.save(product);
    }

    public Product getProduct(Integer id) {
        if(!productRepo.existsById(id)){
            throw new ProductNotFound("product not Found");
        }
        return productRepo.findById(id).get();
    }
    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> productPurchaseRequests){
//        Check if All request product is stored in db
        List<Integer> purchaseIds=productPurchaseRequests.stream().map(ProductPurchaseRequest::getProductId).toList();
        List<Product> storedProducts=productRepo.findAllByIdInOrderById(purchaseIds);
        if(storedProducts.size() !=purchaseIds.size()){
            throw new ProductNotAvaible("Products are not available");
        }
//        Get productPurchaseRequests order by id to be like order same database
        var storedRequest=productPurchaseRequests.stream().sorted(Comparator.comparing(ProductPurchaseRequest::getProductId )).toList();
        List<ProductPurchaseResponse> productPurchaseResponses=new ArrayList<>();

//        Check if quantity of purchase products are avaible
        for (int i=0;i<storedProducts.size();i++){
            var product=storedProducts.get(i);
            var productRequest=storedRequest.get(i);
            if(product.getAvailable_quantity()<productRequest.getQuantity()){
                throw new ProductNotAvaible("product is out of stock");
            }
 //        Update storedProduct available_quantity
            product.setAvailable_quantity(product.getAvailable_quantity()-productRequest.getQuantity());
            productRepo.save(product);
//         Add product to productPurchaseResponse list with new quantity
            ProductPurchaseResponse productPurchaseResponse=new ProductPurchaseResponse();
            productPurchaseResponse.setProductId(product.getId());
            productPurchaseResponse.setName(product.getName());
            productPurchaseResponse.setDescription(product.getDescription());
            productPurchaseResponse.setPrice(product.getPrice());
            productPurchaseResponse.setQuantity(product.getAvailable_quantity());
            productPurchaseResponses.add(productPurchaseResponse);
        }


        return productPurchaseResponses;
    }
}
