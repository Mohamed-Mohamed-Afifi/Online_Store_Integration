package com.ecomm.product.handler;

public class ProductNotAvaible extends RuntimeException {
    public ProductNotAvaible(String productAreNotAvaible) {
        super(productAreNotAvaible);
    }
}
