package com.topica.JDBC;

import com.topica.JDBC.Commit.CommitJava;
import com.topica.JDBC.Rollback.RollbackJava;
import com.topica.JDBC.Savepoint.SavepointJava;

public class Main {
    public static void main(String[] args) {

        // describe RollbackJava
        RollbackJava rollbackJava = new RollbackJava();
        rollbackJava.describe_Rollback();
        // describe CommitJava
        CommitJava commitJava = new CommitJava();
        commitJava.describe_Commit();
        // describe Savepoint
        SavepointJava savepointJava = new SavepointJava();
        savepointJava.describe_Savepoint();
    }
}
