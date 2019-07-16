package com.topica.JDBC.Select;

import com.topica.JDBC.Connect.Connect_DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDB {
    private static final String STRING_SQL = "SELECT * FROM employees";
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;

    public SelectDB() {
        Connect_DB connect_db = new Connect_DB();
        connection = connect_db.getConnection();
    }

    public void exportData() {
        if (connection != null) {
            try {
                callableStatement = connection.prepareCall(STRING_SQL);
                resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt(1) +
                            ", name: " + resultSet.getString(2) +
                            ", address: " + resultSet.getString(3) +
                            ", phone: " + resultSet.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (callableStatement != null) {
                        callableStatement.close();
                    }
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
