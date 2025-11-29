//package com.ecomm.product.mapper;
//
//import com.ecomm.product.dto.CategoryDto;
//import com.ecomm.product.entity.Category;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import java.util.List;
//import java.util.Set;
//
//@Mapper(componentModel = "spring",uses = ProductMapper.class)
//public interface CategoryMapper {
//    @Mapping(source ="name" ,target = "categoryName")
//    @Mapping(source = "products", target = "productDtos")
//    CategoryDto map(Category category);
//    Set<CategoryDto> map(Set<Category> categories);
//    List<CategoryDto> map(List<Category> categories);
//    @Mapping(target = "products", source = "productDtos")
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target ="name" ,source = "categoryName")
//    Category unmap(CategoryDto categoryDto);
//    Set<Category> unmap(Set<CategoryDto> categoryDtos);
//    List<Category> unmap(List<CategoryDto> categoryDtos);
//}
