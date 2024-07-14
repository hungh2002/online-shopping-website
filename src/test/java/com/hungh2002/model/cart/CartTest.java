package com.hungh2002.model.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.sql.Timestamp;
import org.junit.Test;
import com.hungh2002.model.ModelTestInterface;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.product.Product;

public class CartTest implements ModelTestInterface {

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

        long cartId = 1;
        Product product = new Product(productId, name, category, price, image, createAt);
        Customer customer = new Customer(customerId, username, password, sessionId);
        int quantity = 2;

        Cart cart = new Cart(cartId, product, customer, quantity);
        assertEquals(cartId, cart.getCartId());
        assertEquals(product, cart.getProduct());
        assertEquals(customer, cart.getCustomer());
        assertEquals(quantity, cart.getQuantity());
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

        long cartId = 1;
        Product product = new Product(productId, name, category, price, image, createAt);
        Customer customer = new Customer(customerId, username, password, sessionId);
        int quantity = 2;

        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setProduct(product);
        cart.setCustomer(customer);
        cart.setQuantity(quantity);

        assertEquals(cartId, cart.getCartId());
        assertEquals(product, cart.getProduct());
        assertEquals(customer, cart.getCustomer());
        assertEquals(quantity, cart.getQuantity());
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

        long cartId = -1;
        Product product = new Product(productId, name, category, price, image, createAt);
        Customer customer = new Customer(customerId, username, password, sessionId);
        int quantity = 2;

        assertThrows(IllegalArgumentException.class, () -> {
            new Cart(cartId, product, customer, quantity);
        });

        Cart cart = new Cart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.setCartId(cartId);
            cart.setProduct(product);
            cart.setCustomer(customer);
            cart.setQuantity(quantity);
        });
    }
}
