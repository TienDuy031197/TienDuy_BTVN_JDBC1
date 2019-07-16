package com.topica.JDBC_Java;

import com.topica.JDBC_Java.Commit.CommitJava;
import com.topica.JDBC_Java.Rollback.RollbackJava;
import com.topica.JDBC_Java.Savepoint.SavepointJava;

public class Main {
    public static void main(String[] args) {

        // describe RollbackJava
        System.out.println("Rollback in java!");
        RollbackJava rollbackJava = new RollbackJava();
        rollbackJava.describe_Rollback();
        // describe CommitJava
        System.out.println("Commit in java");
        CommitJava commitJava = new CommitJava();
        commitJava.describe_Commit();
        // describe Savepoint
        System.out.println("Savepoint in java");
        SavepointJava savepointJava = new SavepointJava();
        savepointJava.describe_Savepoint();
    }
}
