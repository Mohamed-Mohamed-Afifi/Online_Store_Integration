package com.ecomm.product.service.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseResponse {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;
}
