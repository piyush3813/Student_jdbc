package com.bl.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
    private static String url = "jdbc:mysql://localhost:3306/Data1?user=root&password=admin";
    public static java.sql.Connection instance;

    private SingleConnection() {

    }

    public static java.sql.Connection getInstance() {
        if(instance == null) {
            try {
                instance = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
