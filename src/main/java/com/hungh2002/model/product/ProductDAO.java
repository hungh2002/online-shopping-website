package com.hungh2002.model.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.hungh2002.config.environmentVariable.Env;
import com.hungh2002.service.utils.CreateTableIfNotExists;
import com.hungh2002.service.utils.SQLUtils.SQLStatement;
import com.hungh2002.service.utils.SQLUtils.SQLUtils;

/**
 * ProductDAO
 */
public class ProductDAO extends SQLUtils<Product> {

    public ProductDAO() {
        super("products", Env.CREATE_PRODUCTS_TABLE_SCRIPT);
    }

    @Override
    public Product setResultSetToObject(ResultSet resultSet) {
        Product product = null;

        try {
            long productId = resultSet.getLong("product_id");
            String name = resultSet.getString("name");
            String category = resultSet.getString("category");
            double price = resultSet.getDouble("price");
            String image = resultSet.getString("image");
            Timestamp createAt = resultSet.getTimestamp("create_at");
            product = new Product(productId, name, category, price, image, createAt);

        } catch (Exception e) {
            System.out.println("ProductDAO --> setResultSetToObject() : " + e);
        }
        return product;
    }

    @Override
    public boolean update(Product record) {
        return false;
    }

    @Override
    public void insert(Product record) {
        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("column", " name, category, price, image, create_at ");
        mapData.put("data", " ?, ?, ?, ?, ? ");

        String sqlInsertString = SQLStatement.insert(mapData);
        try {
            PreparedStatement insert = connection.prepareStatement(sqlInsertString);

            insert.setString(1, record.getName());
            insert.setString(2, record.getCategory());
            insert.setDouble(3, record.getPrice());
            insert.setString(4, record.getImage());
            insert.setTimestamp(5, record.getCreateAt());
            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println("ProductDAO --> save() : " + e);
        }
    }

}
