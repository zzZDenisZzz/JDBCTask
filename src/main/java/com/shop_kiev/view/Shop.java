package com.shop_kiev.view;

import com.shop_kiev.model.Product;

import static com.shop_kiev.controler.TableProducts.createTable;
import static com.shop_kiev.controler.TableProducts.insertIntoTable;

public class Shop {
    public static void main(String[] args) {
        Product product = new Product(1, "Milk", 10);
        createTable();
        insertIntoTable(product);

    }
}
