package com.shop_kiev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id) {
        this.id = id;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}