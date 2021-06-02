package com.xulelin.week4.homework;

import java.sql.*;

public class ConnectTest {
    public static void main(String[] args) {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=userdb";
        String username = "sa";
        String password = "admin123456";
        try {
            Class.forName(driver);
            System.out.println("Loading driver succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loading driver failed!");
        }
        try {
            Connection dbConn = DriverManager.getConnection(url, username, password);
            System.out.println("Connect database successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Failed to connect to database!");
        }
    }
}