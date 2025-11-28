package com.ecomm.customer.handlers;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String s) {
        super(s);
    }

}
