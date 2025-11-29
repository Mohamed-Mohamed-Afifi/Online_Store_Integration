//package com.ecomm.product.mapper;
//
//import com.ecomm.product.dto.ProductDto;
//import com.ecomm.product.entity.Product;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import java.util.List;
//import java.util.Set;
//
//@Mapper(componentModel = "spring",uses = CategoryMapper.class)
//public interface ProductMapper {
//
//    @Mapping(target = "productPrice", source = "price")
//    @Mapping(target = "productDescription", source = "description")
//    @Mapping(target = "availableQuantity", source = "available_quantity")
//    @Mapping(source ="name" ,target = "productName")
//    ProductDto map(Product product);
//    Set<ProductDto> map(Set<Product> products);
//    List<ProductDto> map(List<Product> products);
//    @Mapping(target = "name", source = "productName")
//    @Mapping(target = "id", ignore = true)
//    @Mapping(source = "productPrice", target = "price")
//    @Mapping(source = "productDescription", target = "description")
//    @Mapping(source = "availableQuantity", target = "available_quantity")
//    Product unmap(ProductDto productDto);
//    Set<Product> unmap(Set<ProductDto> productDtos);
//    List<Product> unmap(List<ProductDto> productDtos);
//}
