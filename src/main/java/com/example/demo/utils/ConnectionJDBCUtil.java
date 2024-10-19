package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBCUtil {

    private static String DB_URL = "jdbc:mysql://localhost:3306/shopapp";

    private static String USER = "root";

    private static String PASS = "123456";

    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
