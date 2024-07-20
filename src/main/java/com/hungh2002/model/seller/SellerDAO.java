package com.hungh2002.model.seller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.hungh2002.config.environmentVariable.Env;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.customer.CustomerDAO;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;
import com.hungh2002.service.utils.SQLUtils.SQLStatement;
import com.hungh2002.service.utils.SQLUtils.SQLUtils;

public class SellerDAO extends SQLUtils<Seller> {

    public SellerDAO() {
        super("sellers", Env.CREATE_SELLERS_TABLE_SCRIPT);
    }

    public List<Seller> findByCustomerId(long customerId) {
        List<Seller> records = new LinkedList<>();

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("condition", " customer_id = ? ");

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            query.setLong(1, customerId);
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                Seller record = setResultSetToObject(resultSet);
                records.add(record);
            }
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: SellerDAO --> findByCustomerId() : " + e);
        }
        return records;
    }

    public Seller findByCustomerIdAndProductId(long customerId, long productId) {
        Seller record = null;

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("condition", " customer_id = ? AND product_id = ? ");

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            query.setLong(1, customerId);
            query.setLong(2, productId);
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                record = setResultSetToObject(resultSet);
            }
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: SellerDAO --> findByCustomerId() : " + e);
        }
        return record;
    }

    @Override
    public boolean update(Seller seller) {
        boolean updated = false;

        long productId = seller.getProduct().getProductId();
        long customerId = seller.getCustomer().getCustomerId();

        if (exists(productId, customerId) == true) {
            Map<String, String> mapData = new HashMap<>();
            mapData.put("table", table);
            mapData.put("column", " product_id = ?, customer_id = ?, quantity = ? ");
            mapData.put("condition", " seller_id = ? ");

            String sqlUpdateString = SQLStatement.update(mapData);
            try {
                PreparedStatement update = connection.prepareStatement(sqlUpdateString);

                update.setLong(1, productId);
                update.setLong(2, customerId);
                update.setInt(3, seller.getQuantity());
                long sellerId = findByCustomerIdAndProductId(customerId, productId).getSellerId();
                update.setLong(4, sellerId);
                update.executeUpdate();

                updated = true;

            } catch (Exception e) {
                System.out.println("ERROR: SellerDAO --> Update() : " + e);
            }
        }

        return updated;
    }

    @Override
    public void insert(Seller record) {

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("column", " product_id, customer_id, quantity ");
        mapData.put("data", " ?, ?, ? ");

        String sqlInsertString = SQLStatement.insert(mapData);
        try {
            PreparedStatement insert = connection.prepareStatement(sqlInsertString);

            insert.setLong(1, record.getProduct().getProductId());
            insert.setLong(2, record.getCustomer().getCustomerId());
            insert.setInt(3, record.getQuantity());
            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println("CustomerDAO --> save() : " + e);
        }
    }

    @Override
    public Seller setResultSetToObject(ResultSet resultSet) throws SQLException {
        Seller seller = null;
        ProductDAO productDAO = new ProductDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        try {
            long sellerId = resultSet.getLong("seller_id");

            long productId = resultSet.getLong("product_id");
            Product product = productDAO.findById(productId);

            long customerId = resultSet.getLong("customer_id");
            Customer customer = customerDAO.findById(customerId);

            int quantity = resultSet.getInt("quantity");

            seller = new Seller(sellerId, product, customer, quantity);
        } catch (Exception e) {
            System.out.println("SellerDAO --> setResultSetToObject() : " + e);
        } finally {
            productDAO.close();
            customerDAO.close();
        }
        return seller;
    }

    public boolean exists(long productId, long customerId) {
        boolean exists = false;

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("column", "1");
        mapData.put("condition", " product_id=? AND customer_id=? ");

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            query.setLong(1, productId);
            query.setLong(2, customerId);
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
}
