package com.hungh2002.model.customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hungh2002.config.environmentVariable.Env;
import com.hungh2002.service.utils.SQLUtils.SQLStatement;
import com.hungh2002.service.utils.SQLUtils.SQLUtils;

/**
 * CustomerDAO
 */
public class CustomerDAO extends SQLUtils<Customer> {

    public CustomerDAO() {
        super("customers", Env.CREATE_CUSTOMER_TABLE_SCRIPT);
    }

    public Customer findByUsername(String username) {
        Customer record = null;

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("condition", " username = ? ");

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            query.setString(1, username);
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                record = setResultSetToObject(resultSet);
            }
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: SQLUtils --> findAll() : " + e);
        }
        return record;
    }

    @Override
    public Customer setResultSetToObject(ResultSet resultSet) {
        Customer customer = null;

        try {
            long customerId = resultSet.getLong("customer_id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            customer = new Customer(customerId, username, password, null);

        } catch (Exception e) {
            System.out.println("CustomerDAO --> setResultSetToObject() : " + e);
        }
        return customer;
    }

    @Override
    public boolean update(Customer record) {
        return false;
    }

    @Override
    public void insert(Customer record) {
        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("column", " username, password ");
        mapData.put("data", " ?, ? ");

        String sqlInsertString = SQLStatement.insert(mapData);
        try {
            PreparedStatement insert = connection.prepareStatement(sqlInsertString);

            insert.setString(1, record.getUsername());
            insert.setString(2, record.getPassword());
            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println("CustomerDAO --> save() : " + e);
        }
    }
}
