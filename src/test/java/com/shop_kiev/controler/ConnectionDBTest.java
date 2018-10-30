package com.shop_kiev.controler;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

public class ConnectionDBTest {

    @Test
    public void getConnection() {
        Connection connection = ConnectionDB.getConnection();
        assertNotNull(connection);
    }
}