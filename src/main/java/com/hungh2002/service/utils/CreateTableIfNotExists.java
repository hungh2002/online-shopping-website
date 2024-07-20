package com.hungh2002.service.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hungh2002.config.DBConnection;

public class CreateTableIfNotExists extends DBConnection {
    public void execute(String table, String createScript) {
        try {
            PreparedStatement query = connection.prepareStatement(createScript);
            query.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
