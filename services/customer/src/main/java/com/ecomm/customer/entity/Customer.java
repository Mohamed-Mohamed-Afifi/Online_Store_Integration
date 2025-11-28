package com.ecomm.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

@Entity
public class Customer {
    @Id
    private Integer id;
    private String name;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
