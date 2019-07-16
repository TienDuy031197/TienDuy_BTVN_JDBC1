package com.topica.JDBC_Java.Commit;

import com.topica.JDBC_Java.Connect.Connect_DB;
import com.topica.JDBC_Java.Select.SelectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CommitJava {
    private static final String STRING_SQL = "UPDATE employees " +
            "SET name=?, address=?, phone=?" +
            "WHERE id=?;";

    SelectDB selectDB = null;
    Connection connection = null;
    CallableStatement callableStatement = null;

    public CommitJava() {
        Connect_DB connect_db = new Connect_DB();
        selectDB = new SelectDB();
        connection = connect_db.getConnection();
    }

    public void describe_Commit() {
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                callableStatement = connection.prepareCall(STRING_SQL);
                callableStatement.setString(1, "Hung");
                callableStatement.setString(2, "Ha Noi");
                callableStatement.setString(3, "3748713124");
                callableStatement.setInt(4,12);
                callableStatement.execute();

                connection.commit();
                selectDB.exportData();
                System.out.println("Successfully commited changes to the database!");
            } catch (SQLException e) {
                System.out.println("Trung Key!");
                selectDB.exportData();
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
