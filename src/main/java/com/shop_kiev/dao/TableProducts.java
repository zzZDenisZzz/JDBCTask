package com.shop_kiev.dao;

import com.shop_kiev.model.Product;
import com.shop_kiev.util.UtilQuery;
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
                log.info("Product in table");
                return true;
            }
        } catch (SQLException e) {
            log.error("Error inserting into table: {}", e.getMessage());
        }
        return false;
    }

    //Update
    public static int updateToTable(Product product) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.UPDATE)) {
            prStatement.setString(1, product.getName());
            prStatement.setInt(2, product.getPrice());
            prStatement.setInt(3, product.getId());
            // execute update SQL prepared statement
            log.info("Update");
            return prStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error update to table: {}", e.getMessage());
        }
        return 0;
    }

    //Delete record from table
    public static boolean deleteFromTable(Product product) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.DELETE)) {
            prStatement.setInt(1, product.getId());
            // execute delete SQL prepared statement
            final int result = prStatement.executeUpdate();
            if (result == 0) {
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
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                products.add(product);
                log.info("select from table");
            }
        } catch (SQLException e) {
            log.error("Error select from table: {}", e.getMessage());
        }
        return products;
    }

    public static Product selectOne(final int id) {
        try (PreparedStatement pr = ConnectionDB.getConnection().prepareStatement(UtilQuery.SELECT_ONE)) {
            Product product = new Product();
            pr.setInt(1, id);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                }
                log.info("Select one product");
                return product;
            }
        } catch (SQLException e) {
            log.error("Error Select one product: {}", e.getMessage());
        }
        return null;
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
