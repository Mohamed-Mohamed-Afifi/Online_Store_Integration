package com.ecomm.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class CustomerDto {
    @NotNull(message = "Customer Name is Required")
    private String name;
    private String age;
    @Email(message = "customer email not valid")
    private String email;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
