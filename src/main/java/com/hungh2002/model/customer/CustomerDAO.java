package com.hungh2002.model.customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.hungh2002.config.DBConnection;
import com.hungh2002.service.utils.SQLStatement;

/**
 * CustomerDAO
 */
public class CustomerDAO extends DBConnection {

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("customerDAOSQL.close: " + e);
        }
    }

    public ResultSet queryData(String orderByColumn, String sortOrder, String where,
            List<String> auth, String limit) {
        ResultSet resultSet = null;

        // SQL statements
        // --> "SELECT * FROM products ORDER BY ${orderByColumn} ${sortOrder} LIMIT ${limit}"
        String sqlQueryString =
                SQLStatement.select("*", "customers", orderByColumn, sortOrder, where, limit);

        // execute the SQL statement
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);

            for (int i = 0; i < auth.size(); i++) {
                query.setString(i + 1, auth.get(i));
            }

            resultSet = query.executeQuery();
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("productDAOSQL -SELECT: " + e);
        }
        return resultSet;
    }


    public void insertData(String username, String password, String sessionId) {

        String column = "username, password, sessionId";

        String sqlInsertString = SQLStatement.insert("customers", column, "?,?,?");

        try {
            PreparedStatement insert = connection.prepareStatement(sqlInsertString);
            insert.setString(1, username);
            insert.setString(2, password);
            insert.setString(3, sessionId);
            insert.executeUpdate();
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("customerDAOSQL: " + e);
        }
    }
}
