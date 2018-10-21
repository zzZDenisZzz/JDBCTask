package com.shop_kiev.controler;

class UtilQuery {

    public UtilQuery() {
    }

    static final String CREATE_TABLE = "CREATE TABLE PRODUCTS " +
            "(id INT NOT NULL AUTO_INCREMENT, " +
            "name VARCHAR(30), " +
            "price INT NOT NULL, " +
            "PRIMARY KEY (id))";
    static final String INSERT = "INSERT INTO PRODUCTS (name, price) VALUES (?, ?);";
    static final String UPDATE = "UPDATE PRODUCTS SET name = ?, price = ? WHERE id = ?;";
    static final String DELETE = "DELETE FROM PRODUCTS WHERE name = ?;";

}
