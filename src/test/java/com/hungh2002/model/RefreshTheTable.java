package com.hungh2002.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import com.hungh2002.config.DBConnection;

public class RefreshTheTable extends DBConnection {

    public void execute(String table, String createScript) throws SQLException {
        dropTable(table);
        createTable(createScript);
    }

    public void dropForeignKey() throws SQLException {
        String sqlDropForeignKeyString = " SET FOREIGN_KEY_CHECKS=0 ";
        Statement dropForeignKey = connection.createStatement();
        dropForeignKey.execute(sqlDropForeignKeyString);
    }

    public void recoverForeignKey() throws SQLException {
        String sqlRecoverForeignKeyString = " SET FOREIGN_KEY_CHECKS=1 ";
        Statement recoverForeignKey = connection.createStatement();
        recoverForeignKey.execute(sqlRecoverForeignKeyString);
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

    public void createTable(String createScript) throws SQLException {
        PreparedStatement query = connection.prepareStatement(createScript);
        query.execute();
    }
}
