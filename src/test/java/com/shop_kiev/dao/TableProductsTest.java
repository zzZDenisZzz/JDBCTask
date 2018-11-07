package com.shop_kiev.dao;

import com.shop_kiev.model.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TableProductsTest {
    private Product product = new Product(1, "Chocolate", 60);
    private Product product2 = new Product(1, "Bread", 50);

    @Test
    public void createTable() {
        int create = TableProducts.createTable();
        assertEquals(0, create);
    }

    @Test
    public void insertIntoTable() {
        assertTrue(TableProducts.insertIntoTable(product));
    }

    @Test
    public void updateToTable() {
        assertTrue(TableProducts.updateToTable(product, product2));
    }

    @Test
    public void deleteFromTable() {
        assertTrue(TableProducts.deleteFromTable(product2));
    }

    @Test
    public void dropTable() {
        int result = TableProducts.dropTable();
        assertEquals(0, result);
    }
}