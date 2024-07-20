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

import com.hungh2002.model.seller.Seller;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.product.Product;

public class SellerServiceTest {
    private static Product product1 = new Product(1, "name1", "category1", 1.1, "image1",
            new Timestamp(System.currentTimeMillis()));
    private static Product product2 = new Product(2, "name2", "category2", 2.2, "image2",
            new Timestamp(System.currentTimeMillis()));
    private static Product product3 = new Product(3, "name3", "category3", 3.3, "image3",
            new Timestamp(System.currentTimeMillis()));

    private static Customer customer1 = new Customer(1, "username1", "password1", null);
    private static Customer customer2 = new Customer(2, "username2", "password2", null);
    private static Customer customer3 = new Customer(3, "username3", "password3", null);

    private static Seller seller1 = new Seller(1, product1, customer1, 3);
    private static Seller seller2 = new Seller(2, product2, customer2, 2);
    private static Seller seller3 = new Seller(3, product3, customer3, 1);

    private static SellerService sellerService;

    @BeforeAll
    public static void setup() {
        sellerService = mock(SellerService.class);
    }

    @Test
    void testAddProductToSeller() {

    }

    @Test
    void testGetSeller() throws SQLException {
        List<Seller> list = new ArrayList<>();
        list.add(seller2);
        when(sellerService.getSellerList(customer2.getCustomerId())).thenReturn(list);

    }

    @Test
    void testGetSellerList() {
        List<Seller> list = new ArrayList<>();
        list.add(seller2);

        when(sellerService.getSellerList(customer2.getCustomerId())).thenReturn(list);
        assertEquals(sellerService.getSellerList(customer2.getCustomerId()), list);
    }
}

