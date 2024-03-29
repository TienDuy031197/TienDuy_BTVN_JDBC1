package com.topica.JDBC_Java.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_DB {

    public Connection getConnection() {
        try {
            Class.forName(Config.CLASS_NAME);
            return DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

}
