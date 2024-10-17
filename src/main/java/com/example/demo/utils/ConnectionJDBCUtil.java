package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.hibernate.cfg.JdbcSettings.PASS;
import static org.hibernate.cfg.JdbcSettings.USER;

public class ConnectionJDBCUtil {
    @Value("${DB_URL}")
    private static String DB_URL;

    @Value("${username}")
    private static String USER;

    @Value("${pass}")
    private static String PASS;

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
