package com.shop_kiev.view;

import com.shop_kiev.controler.TableProducts;
import com.shop_kiev.model.Product;

public class Shop {
    public static void main(String[] args) {
        Product product = new Product(1, "Milk", 10);
        Product newProduct = new Product(1, "Coca-cola", 10);
        TableProducts.createTable();
        TableProducts.insertIntoTable(product);
        TableProducts.updateToTable(product, newProduct);
        TableProducts.selectFromTable();
        TableProducts.deleteFromTable(newProduct);
        TableProducts.dropTable();
    }
}
