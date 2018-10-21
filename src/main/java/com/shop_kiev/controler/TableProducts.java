package com.shop_kiev.controler;

import com.shop_kiev.model.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableProducts {
    //Creates a table in a database.
    public static void createTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.CREATE_TABLE)) {
            prStatement.executeUpdate();
            System.out.println("Create Table!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //Insert table
    public static void insertIntoTable(Product product) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.INSERT)) {
            prStatement.setString(1, product.getName());
            prStatement.setInt(2, product.getPrice());

            // execute insert SQL prepared statement
            prStatement.executeUpdate();
            System.out.println("First product in table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Update
    public static void updateToTable(Product oldProduct, Product newProduct) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.UPDATE)) {
            prStatement.setString(1, newProduct.getName());
            prStatement.setInt(2, newProduct.getPrice());
            prStatement.setInt(3, oldProduct.getId());

            // execute update SQL prepared statement
            prStatement.executeUpdate();
            System.out.println("Update");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Delete record from table
    public static void deleteFromTable(Product product) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.DELETE)) {
            prStatement.setString(1, product.getName());

            // execute delete SQL prepared statement
            prStatement.executeUpdate();
            System.out.println("Delete");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
