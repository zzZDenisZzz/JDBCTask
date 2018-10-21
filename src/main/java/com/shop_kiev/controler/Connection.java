package com.shop_kiev.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionDB {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/shop";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = " ";

    //Connection DB
    static Connection getConnection() {
        Connection dbConnection = null;
        //Step 1 DRIVER
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Step 2 Opening the connection.
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
