package com.hungh2002.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hungh2002.model.cart.Cart;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.product.Product;

public class CartServiceTest {
    private static Product product1 = new Product(1, "name1", "category1", 1.1, "image1",
            new Timestamp(System.currentTimeMillis()));
    private static Product product2 = new Product(2, "name2", "category2", 2.2, "image2",
            new Timestamp(System.currentTimeMillis()));
    private static Product product3 = new Product(3, "name3", "category3", 3.3, "image3",
            new Timestamp(System.currentTimeMillis()));

    private static Customer customer1 = new Customer(1, "username1", "password1", null);
    private static Customer customer2 = new Customer(2, "username2", "password2", null);
    private static Customer customer3 = new Customer(3, "username3", "password3", null);

    private static Cart cart1 = new Cart(1, product1, customer1, 3);
    private static Cart cart2 = new Cart(2, product2, customer2, 2);
    private static Cart cart3 = new Cart(3, product3, customer3, 1);

    private static CartService cartService;

    @BeforeAll
    public static void setup() {
        cartService = mock(CartService.class);
    }

    @Test
    void testAddProductToCart() {

    }

    @Test
    void testGetCart() throws SQLException {
        List<Cart> list = new ArrayList<>();
        list.add(cart2);
        when(cartService.getCartList(customer2.getCustomerId())).thenReturn(list);

    }

    @Test
    void testGetCartList() {
        List<Cart> list = new ArrayList<>();
        list.add(cart2);

        when(cartService.getCartList(customer2.getCustomerId())).thenReturn(list);
        assertEquals(cartService.getCartList(customer2.getCustomerId()), list);
    }
}
