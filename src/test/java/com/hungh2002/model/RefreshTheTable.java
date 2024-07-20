package com.hungh2002.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import com.hungh2002.config.DBConnection;

public class RefreshTheTable extends DBConnection {

    public void execute(String table, String createScript) {
        dropTable(table);
        createTable(createScript);
    }

    public void dropForeignKey() {
        String sqlDropForeignKeyString = " SET FOREIGN_KEY_CHECKS=0 ";
        try {
            Statement dropForeignKey = connection.createStatement();
            dropForeignKey.execute(sqlDropForeignKeyString);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void recoverForeignKey() {
        String sqlRecoverForeignKeyString = " SET FOREIGN_KEY_CHECKS=1 ";
        try {
            Statement recoverForeignKey = connection.createStatement();
            recoverForeignKey.execute(sqlRecoverForeignKeyString);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dropTable(String table) {
        try {
            dropForeignKey();

            String sqlDropTableString = " DROP TABLE IF EXISTS " + table;
            Statement drop = connection.createStatement();
            drop.execute(sqlDropTableString);

            recoverForeignKey();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void createTable(String createScript) {
        try {
            PreparedStatement query = connection.prepareStatement(createScript);
            query.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
