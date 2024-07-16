package com.hungh2002.model.cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.hungh2002.config.DBConnection;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.customer.CustomerDAO;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;
import com.hungh2002.service.utils.SQLUtils.SQLStatement;
import com.hungh2002.service.utils.SQLUtils.SQLUtils;

public class CartDAO extends SQLUtils<Cart> {

    public CartDAO() {
        super("cart");
    }

    public List<Cart> findByCustomerId(long customerId) {
        List<Cart> records = new LinkedList<>();

        Map<String, String> mapData = new HashMap<>();
        mapData.put("table", table);
        mapData.put("condition", " customer_id = ? ");

        String sqlQueryString = SQLStatement.select(mapData);
        try {
            PreparedStatement query = connection.prepareStatement(sqlQueryString);
            query.setLong(1, customerId);
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                Cart record = setResultSetToObject(resultSet);
                records.add(record);
            }
        } catch (Exception e) {
            // Print error if there is a problem
            System.out.println("ERROR: CartDAO --> findByCustomerId() : " + e);
        }
        return records;
    }

    public Cart findByCustomerIdAndProductId(long customerId, long productId) {
        Cart record = null;

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
            System.out.println("ERROR: CartDAO --> findByCustomerId() : " + e);
        }
        return record;
    }

    @Override
    public boolean update(Cart cart) {
        boolean updated = false;

        long productId = cart.getProduct().getProductId();
        long customerId = cart.getCustomer().getCustomerId();

        if (exists(productId, customerId) == true) {
            Map<String, String> mapData = new HashMap<>();
            mapData.put("table", table);
            mapData.put("column", " product_id = ?, customer_id = ?, quantity = ? ");
            mapData.put("condition", " cart_id = ? ");

            String sqlUpdateString = SQLStatement.update(mapData);
            try {
                PreparedStatement update = connection.prepareStatement(sqlUpdateString);

                update.setLong(1, productId);
                update.setLong(2, customerId);
                update.setInt(3, cart.getQuantity());
                long cartId = findByCustomerIdAndProductId(customerId, productId).getCartId();
                update.setLong(4, cartId);
                update.executeUpdate();

                updated = true;

            } catch (Exception e) {
                System.out.println("ERROR: cartDAO --> Update() : " + e);
            }
        }

        return updated;
    }

    @Override
    public void insert(Cart record) {

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
    public Cart setResultSetToObject(ResultSet resultSet) {
        Cart cart = null;
        ProductDAO productDAO = new ProductDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        try {
            long cartId = resultSet.getLong("cart_id");

            long productId = resultSet.getLong("product_id");
            Product product = productDAO.findById(productId);

            long customerId = resultSet.getLong("customer_id");
            Customer customer = customerDAO.findById(customerId);

            int quantity = resultSet.getInt("quantity");

            cart = new Cart(cartId, product, customer, quantity);
        } catch (Exception e) {
            System.out.println("CartDAO --> setResultSetToObject() : " + e);
        } finally {
            productDAO.close();
            customerDAO.close();
        }
        return cart;
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
