package com.hungh2002.model.product;

import java.sql.ResultSet;
import java.sql.Timestamp;
import com.hungh2002.service.utils.SQLUtils.SQLUtils;

/**
 * ProductDAO
 */
public class ProductDAO extends SQLUtils<Product> {

    public ProductDAO() {
        super("products");
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
    public void save(Product record) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean update(Product record) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void insert(Product record) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

}
