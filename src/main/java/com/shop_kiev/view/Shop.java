package com.shop_kiev.view;

import com.shop_kiev.controler.TableProducts;
import com.shop_kiev.model.Product;
import com.shop_kiev.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Shop {
    public static void main(String[] args) {
        Product product = new Product(1, "Milk", 10);
        Product newProduct = new Product(1, "Coca-cola", 15);
        TableProducts.createTable();
        TableProducts.insertIntoTable(product);
        TableProducts.updateToTable(product, newProduct);
        TableProducts.selectFromTable();
        TableProducts.deleteFromTable(newProduct);
        TableProducts.dropTable();

        // Number of percent
        log.info(NumberUtil.calculatePercentWithRound(1, 60, 2) + "%");
    }
}
