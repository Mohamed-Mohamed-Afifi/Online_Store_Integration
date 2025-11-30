package com.ecomm.order.handler;

public class BusinessException extends RuntimeException {
    public BusinessException(String errorDuringPurchaseProducts) {
        super(errorDuringPurchaseProducts);
    }
}
