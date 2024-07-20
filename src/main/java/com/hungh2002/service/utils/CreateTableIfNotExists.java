package com.hungh2002.service.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hungh2002.config.DBConnection;

public class CreateTableIfNotExists extends DBConnection {
    public void execute(String table, String createScript) throws SQLException {
        PreparedStatement query = connection.prepareStatement(createScript);
        query.execute();
    }
}
