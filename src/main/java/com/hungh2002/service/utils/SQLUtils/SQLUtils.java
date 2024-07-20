package com.hungh2002.service.utils.SQLUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.hungh2002.config.DBConnection;
import com.hungh2002.service.utils.CreateTableIfNotExists;

/**
 * SQLUtils
 */
public abstract class SQLUtils<T> extends DBConnection {

    protected String table;

    protected SQLUtils(String table, String createTableIfNotExists) {
        this.table = table;
        new CreateTableIfNotExists().execute(table, createTableIfNotExists);;
    }

    public abstract boolean update(T record);

    public abstract void insert(T record);

    public abstract T setResultSetToObject(ResultSet resultSet) throws SQLException;

    public List<T> findAll(String orderBy) {
        List<T> records = new LinkedList<>();

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        if (orderBy != null) {
            mapData.put("order-by", orderBy);
        }

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                T record = setResultSetToObject(resultSet);
                records.add(record);
            }
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: SQLUtils --> findAll() : " + e);
        }

        return records;
    }

    public List<T> findAll() {
        return findAll(null);
    }

    public List<T> findAllWithLimit(int limit, String orderBy) {
        List<T> records = new LinkedList<>();

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        if (orderBy != null) {
            mapData.put("order-by", orderBy);
        }
        mapData.put("limit", String.valueOf(limit));

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                T record = setResultSetToObject(resultSet);
                records.add(record);
            }
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: SQLUtils --> findAll() : " + e);
        }

        return records;
    }

    public List<T> findAllWithLimit(int limit) {
        return findAllWithLimit(limit, null);
    }

    public T findById(long id) {
        T record = null;

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("condition", table.replaceAll("s$", "_id = ? "));

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);

            query.setLong(1, id);
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

    public boolean exists(String selectedColumn, String data) {
        boolean exists = false;

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("column", " 1 ");
        mapData.put("condition", selectedColumn + " =? ");

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            query.setString(1, data);
            ResultSet resultSet = query.executeQuery();

            if (resultSet.next() == true) {
                exists = true;
            }
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: SQLUtils --> exists() : " + e);
        }
        return exists;
    }

    public boolean exists(String selectedColumn, long data) {
        return exists(selectedColumn, String.valueOf(data));
    }

    public void save(T record) {
        if (update(record) == false) {
            insert(record);
        }
    }

}
