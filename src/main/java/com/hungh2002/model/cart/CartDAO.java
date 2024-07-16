package com.hungh2002.model.cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
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

    public void insertData(LinkedHashMap<String, String> args) {

        // Count the number of columns you want to insert data.
        String valueNumbers = "";
        for (int i = 0; i < args.size() - 3; i++) {
            valueNumbers = valueNumbers + " ?,";
        }
        // " ${x}, ${y}, ${z}, " --> " ${x}, ${y}, ${z} "
        valueNumbers = valueNumbers.replaceAll(",$", "");
        args.put("data", valueNumbers);

        String sqlInsertString = SQLStatement.insert(args);

        try {
            PreparedStatement insert = connection.prepareStatement(sqlInsertString);

            int valueNumbersIndex = 1;
            for (Map.Entry<String, String> element : args.entrySet()) {
                if (!element.getKey().equals("table") && !element.getKey().equals("column")
                        && !element.getKey().equals("data")
                        && !element.getKey().equals("condition")) {
                    try {
                        insert.setString(valueNumbersIndex, element.getValue());
                        valueNumbersIndex++;
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        System.out.println("ERROR: cartDAO --> Insert --> forEach: " + e);
                    }
                }
            }
            valueNumbersIndex = 1;
            insert.executeUpdate();
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: cartDAO --> Insert: " + e);
        }
    }

    public void updateData(LinkedHashMap<String, String> args) {

        String sqlUpdateString = SQLStatement.update(args);
        try {
            PreparedStatement update = connection.prepareStatement(sqlUpdateString);

            update.setString(1, args.get("quantity"));
            update.setString(2, args.get("cart-id"));
            update.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR: cartDAO --> Update: " + e);
        }
    }
}
