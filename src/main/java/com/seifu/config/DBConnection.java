package com.seifu.config;

import java.sql.Connection;
import java.sql.DriverManager;

import com.seifu.config.environmentVariable.Env;

public class DBConnection {

    protected Connection connection = null;

    public DBConnection() {
        // // Get the environment variable from the Env file,
        // and combine it into a Database url
        //// How to get the variable from the.env file ->>
        // Env.$STRING_VARIABLE_NAME;
        //// combine string =>> "jdbc:mariadb://localhost:3306/user_name"
        String databaseUrl = "jdbc:" + Env.RDBMS
                + "://" + Env.HOST
                + ":" + Env.PORT_OF_HOST
                + "/" + Env.DATABASE_NAME;

        // create database connection for a server installed in host, with database url
        // name, user, password
        try {
            connection = DriverManager.getConnection(databaseUrl, Env.USERNAME,
                    Env.PASSWORD);
        } catch (Exception e) {
            System.out.println("Database connection error: " + e);
        }
    }
}
