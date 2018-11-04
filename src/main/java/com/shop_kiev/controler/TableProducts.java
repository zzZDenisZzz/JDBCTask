package com.shop_kiev.controler;

import com.shop_kiev.model.Product;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TableProducts {
    private TableProducts() {
    }

    //Creates a table in a database.
    public static int createTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.CREATE_TABLE)) {
            final int result = prStatement.executeUpdate();
            if (result == 0) {
                log.info("Created table");
                return 0;
            }
        } catch (SQLException e) {
            log.error("Error, the table is not created: {}", e.getMessage());
        }
        return -1;
    }

    //Insert table
    public static boolean insertIntoTable(Product product) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.INSERT)) {
            prStatement.setString(1, product.getName());
            prStatement.setInt(2, product.getPrice());
            // execute insert SQL prepared statement
            final int result = prStatement.executeUpdate();
            if (result > 0) {
                log.info("First product in table");
                return true;
            }
        } catch (SQLException e) {
            log.error("Error inserting into table: {}", e.getMessage());
        }
        return false;
    }

    //Update
    public static boolean updateToTable(Product oldProduct, Product newProduct) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.UPDATE)) {
            prStatement.setString(1, newProduct.getName());
            prStatement.setInt(2, newProduct.getPrice());
            prStatement.setInt(3, oldProduct.getId());
            // execute update SQL prepared statement
            final int result = prStatement.executeUpdate();
            if (result > 0) {
                log.info("Update");
                return true;
            }
        } catch (SQLException e) {
            log.error("Error update to table: {}", e.getMessage());
        }
        return false;
    }

    //Delete record from table
    public static boolean deleteFromTable(Product product) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.DELETE)) {
            prStatement.setString(1, product.getName());
            // execute delete SQL prepared statement
            final int result = prStatement.executeUpdate();
            if (result > 0) {
                log.info("Delete");
                return true;
            }
        } catch (SQLException e) {
            log.error("Error delete from table: {}", e.getMessage());
        }
        return false;
    }

    //Select records from table
    public static List<Product> selectFromTable() {
        List<Product> products = new ArrayList<>();
        try (final PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.SELECT);
             final ResultSet rs = prStatement.executeQuery()) {
            // execute select SQL prepared statement
            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                products.add(product);
                log.info("Id: {}, Name product: {}, Price: {}", id, name, price);
            }
        } catch (SQLException e) {
            log.error("Error select from table: {}", e.getMessage());
        }
        return products;
    }

    //Drop from table
    public static int dropTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.DROP)) {
            // execute delete SQL prepared statement
            final int result = prStatement.executeUpdate();
            if (result == 0) {
                log.info("Drop table");
                return 0;
            }
        } catch (SQLException e) {
            log.error("Drop error: {}", e.getMessage());
        }
        return -1;
    }
}
