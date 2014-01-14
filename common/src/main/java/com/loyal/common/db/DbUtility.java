package com.loyal.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
    
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "loyal";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "amar";
        String password = "amar";
        try {
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(url+dbName,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(IllegalAccessException ex){
            ex.printStackTrace();
        }catch(InstantiationException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
