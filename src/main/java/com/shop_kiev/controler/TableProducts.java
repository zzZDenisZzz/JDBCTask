package com.shop_kiev.controler;

import com.shop_kiev.model.Product;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class TableProducts {
    private TableProducts() {
    }

    //Creates a table in a database.
    public static void createTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.CREATE_TABLE)) {
            prStatement.executeUpdate();
            log.info("Create Table!!!");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    //Insert table
    public static void insertIntoTable(Product product) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.INSERT)) {
            prStatement.setString(1, product.getName());
            prStatement.setInt(2, product.getPrice());
            // execute insert SQL prepared statement
            prStatement.executeUpdate();
            log.info("First product in table");
        } catch (SQLException e) {
            log.error(e.getMessage());
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
            log.info("Update");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    //Delete record from table
    public static void deleteFromTable(Product product) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.DELETE)) {
            prStatement.setString(1, product.getName());
            // execute delete SQL prepared statement
            prStatement.executeUpdate();
            log.info("Delete");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    //Select records from table
    public static void selectFromTable() {
        try (final PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.SELECT);
             final ResultSet rs = prStatement.executeQuery()) {
            // execute select SQL prepared statement
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                log.info("Id: " + id);
                log.info("Name product: " + name);
                log.info("Price: " + price);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    //Drop from table
    public static void dropTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.DROP)) {
            // execute delete SQL prepared statement
            prStatement.executeUpdate();
            log.info("Drop table!!!");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
