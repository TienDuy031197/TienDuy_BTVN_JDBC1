package com.topica.JDBC.Savepoint;

import com.topica.JDBC.Connect.Connect_DB;
import com.topica.JDBC.Select.SelectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

public class SavepointJava {
    private static final String STRING_SQL = "DELETE FROM employees WHERE id = ?";
    Connection connection = null;
    CallableStatement callableStatement = null;
    SelectDB selectDB = null;

    public SavepointJava() {
        selectDB = new SelectDB();
        Connect_DB connect_db = new Connect_DB();
        connection = connect_db.getConnection();
    }

    public void describe_Savepoint() {
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                callableStatement = connection.prepareCall(STRING_SQL);

                callableStatement.setInt(1, 8);
                callableStatement.execute();

                Savepoint savepoint_1 = connection.setSavepoint();
                callableStatement.setInt(1, 2);
                callableStatement.execute();

                callableStatement.setInt(1, 3);
                callableStatement.execute();

                connection.rollback(savepoint_1);
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
