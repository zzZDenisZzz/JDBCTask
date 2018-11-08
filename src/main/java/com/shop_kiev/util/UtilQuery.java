package com.shop_kiev.util;

public final class UtilQuery {
    private UtilQuery() {
    }

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS PRODUCTS" +
            "(id INT NOT NULL AUTO_INCREMENT, " +
            "name VARCHAR(30), " +
            "price INT NOT NULL, " +
            "PRIMARY KEY (id))";
    public static final String INSERT = "INSERT INTO PRODUCTS (name, price) VALUES (?, ?);";
    public static final String UPDATE = "UPDATE PRODUCTS SET name = ?, price = ? WHERE id = ?;";
    public static final String DELETE = "DELETE FROM PRODUCTS WHERE id = ?;";
    public static final String SELECT = "SELECT * FROM PRODUCTS;";
    public static final String DROP = "DROP TABLE PRODUCTS;";
}
