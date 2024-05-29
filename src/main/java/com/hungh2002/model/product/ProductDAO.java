package com.hungh2002.model.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.hungh2002.config.DBConnection;
import com.hungh2002.service.utils.SQLStatement;

/**
 * ProductDAO
 */
public class ProductDAO extends DBConnection {

    public ResultSet queryData(String orderByColumn, String sortOrder, String where, String limit) {
        ResultSet resultSet = null;

        // SQL statements
        // --> "SELECT * FROM products ORDER BY ${orderByColumn} ${sortOrder} LIMIT ${limit}"
        String sqlQueryString =
                SQLStatement.select("*", "products", orderByColumn, sortOrder, where, limit);

        // execute the SQL statement
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            resultSet = query.executeQuery();
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("productDAOSQL: " + e);
        }
        return resultSet;
    }

}
