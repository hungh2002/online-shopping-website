package com.hungh2002.model.cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;

import com.hungh2002.config.DBConnection;
import com.hungh2002.service.utils.SQLStatement;

public class CartDAO extends DBConnection {
    public ResultSet queryData(LinkedHashMap<String, String> args) {
        ResultSet resultSet = null;

        // SQL statements
        // --> "SELECT ${column} FROM ${table} ORDER BY ${orderBy} LIMIT ${limit} WHERE
        // id=${id}"
        String sqlQueryString = SQLStatement.select(args);

        // execute the SQL statement
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            query.setString(1, args.get("customer-id"));

            resultSet = query.executeQuery();
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: CartDAO -> SQL -> Query : " + e);
        }
        return resultSet;
    }
}
