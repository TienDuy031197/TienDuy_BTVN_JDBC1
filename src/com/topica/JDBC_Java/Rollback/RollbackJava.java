package com.topica.JDBC_Java.Rollback;

import com.topica.JDBC_Java.Connect.Connect_DB;
import com.topica.JDBC_Java.Select.SelectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RollbackJava {
    private static final String STRING_SQL = "DELETE FROM employees WHERE id = ?;";

    Connection connection = null;
    CallableStatement callableStatement = null;
    SelectDB selectDB = null;

    public RollbackJava() {
        Connect_DB connect_db = new Connect_DB();
        connection = connect_db.getConnection();
        selectDB = new SelectDB();
    }

    public void describe_Rollback() {
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                callableStatement = connection.prepareCall(STRING_SQL);
                callableStatement.setInt(1, 2);
                callableStatement.execute();

                connection.rollback();
                connection.commit();
                selectDB.exportData();
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
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
