package com.ecomm.product.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;

@RestControllerAdvice
public class ProductHandlerExceptions {

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<?> handleProductNotfound(Exception ex){
        HashMap<String,String> errorMap=new HashMap<>();
        errorMap.put("Error", ex.getMessage());
        errorMap.put("StackTrace", Arrays.toString(ex.getStackTrace()));
        errorMap.put("Status","Error");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
    }
    @ExceptionHandler(ProductNotAvaible.class)
    public ResponseEntity<?> handleProductNotAvaible(Exception ex){
        HashMap<String,String> errorMap=new HashMap<>();
        errorMap.put("Error", ex.getMessage());
        errorMap.put("StackTrace", Arrays.toString(ex.getStackTrace()));
        errorMap.put("Status","Error");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
    }
}
