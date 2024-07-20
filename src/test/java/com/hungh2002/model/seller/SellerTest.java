package com.hungh2002.model.seller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.sql.Timestamp;
import org.junit.Test;
import com.hungh2002.model.ModelTestInterface;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.product.Product;

public class SellerTest implements ModelTestInterface {

    @Override
    @Test
    public void testGet() {
        long productId = 1;
        String name = "name";
        String category = "category";
        double price = 1.2;
        String image = "image";
        Timestamp createAt = new Timestamp(System.currentTimeMillis());

        long customerId = 1;
        String username = "username";
        String password = "password";
        String sessionId = null;

        long sellerId = 1;
        Product product = new Product(productId, name, category, price, image, createAt);
        Customer customer = new Customer(customerId, username, password, sessionId);
        int quantity = 2;

        Seller seller = new Seller(sellerId, product, customer, quantity);
        assertEquals(sellerId, seller.getSellerId());
        assertEquals(product, seller.getProduct());
        assertEquals(customer, seller.getCustomer());
        assertEquals(quantity, seller.getQuantity());
    }

    @Override
    @Test
    public void testSet() {
        long productId = 1;
        String name = "name";
        String category = "category";
        double price = 1.2;
        String image = "image";
        Timestamp createAt = new Timestamp(System.currentTimeMillis());

        long customerId = 1;
        String username = "username";
        String password = "password";
        String sessionId = null;

        long sellerId = 1;
        Product product = new Product(productId, name, category, price, image, createAt);
        Customer customer = new Customer(customerId, username, password, sessionId);
        int quantity = 2;

        Seller seller = new Seller();
        seller.setSellerId(sellerId);
        seller.setProduct(product);
        seller.setCustomer(customer);
        seller.setQuantity(quantity);

        assertEquals(sellerId, seller.getSellerId());
        assertEquals(product, seller.getProduct());
        assertEquals(customer, seller.getCustomer());
        assertEquals(quantity, seller.getQuantity());
    }

    @Override
    @Test
    public void testException() {
        long productId = 1;
        String name = "name";
        String category = "category";
        double price = 1.2;
        String image = "image";
        Timestamp createAt = new Timestamp(System.currentTimeMillis());

        long customerId = 1;
        String username = "username";
        String password = "password";
        String sessionId = null;

        long sellerId = -1;
        Product product = new Product(productId, name, category, price, image, createAt);
        Customer customer = new Customer(customerId, username, password, sessionId);
        int quantity = 2;

        assertThrows(IllegalArgumentException.class, () -> {
            new Seller(sellerId, product, customer, quantity);
        });

        Seller seller = new Seller();
        assertThrows(IllegalArgumentException.class, () -> {
            seller.setSellerId(sellerId);
            seller.setProduct(product);
            seller.setCustomer(customer);
            seller.setQuantity(quantity);
        });
    }
}

