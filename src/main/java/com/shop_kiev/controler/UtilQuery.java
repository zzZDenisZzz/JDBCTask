package com.shop_kiev.controler;

class UtilQuery {

    public UtilQuery() {
    }

    static final String CREATE_TABLE = "CREATE TABLE product " +
            "(id INTEGER NOT NULL, " +
            "name VARCHAR(30), " +
            "price INTEGER NOT NULL, " +
            "PRIMARY KEY (id))";
}
