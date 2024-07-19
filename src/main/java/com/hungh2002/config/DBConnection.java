package com.hungh2002.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.hungh2002.config.environmentVariable.Env;

public class DBConnection {

    protected Connection connection = null;

    public DBConnection() {
        String databaseUrl = "jdbc:" + Env.RDBMS + "://" + Env.HOST + ":" + Env.PORT_OF_HOST + "/"
                + Env.DATABASE_NAME;
        try {
            connection = DriverManager.getConnection(databaseUrl, Env.USERNAME, Env.PASSWORD);
        } catch (Exception e) {
            System.out.println("Database connection error: " + e);
        }

    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("ERROR: DBConnection -> Close: " + e);
        }
    }
}
