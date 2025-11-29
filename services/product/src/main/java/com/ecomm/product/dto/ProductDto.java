package com.ecomm.product.dto;

import com.ecomm.product.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String productName;
    private String productDescription;
    private double availableQuantity;
    private BigDecimal productPrice;
    private CategoryDto category;

}
