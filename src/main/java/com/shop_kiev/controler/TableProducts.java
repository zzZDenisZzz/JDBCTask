package com.shop_kiev.controler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableProducts {
    //Creates a table in a database.
    public static void createTable(){
        try(PreparedStatement prStatement = ConnectionDB.getConnection().prepareStatement(UtilQuery.CREATE_TABLE)){
            prStatement.executeUpdate();
            System.out.println("Create Table !!!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
