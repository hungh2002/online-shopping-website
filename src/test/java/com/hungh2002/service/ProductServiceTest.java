package com.hungh2002.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.hungh2002.model.product.Product;

public class ProductServiceTest {

    private static Product product1 = new Product(1, "name1", "category1", 1.1, "image1",
            new Timestamp(System.currentTimeMillis()));
    private static Product product2 = new Product(2, "name2", "category2", 2.2, "image2",
            new Timestamp(System.currentTimeMillis()));
    private static Product product3 = new Product(3, "name3", "category3", 3.3, "image3",
            new Timestamp(System.currentTimeMillis()));

    private static ProductService productService;

    @BeforeAll
    public static void setup() {
        productService = mock(ProductService.class);
    }

    @Test
    void testGetProduct() {
        List<Product> productsList = new ArrayList<>();
        productsList.add(product2);
        when(productService.getProduct(2)).thenReturn(productsList);
        assertEquals(productService.getProduct(2), productsList);
    }

    @Test
    void testGetProductsList() {
        List<Product> productsList = new ArrayList<>();
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);

        when(productService.getProductsList()).thenReturn(productsList);
        assertEquals(productService.getProductsList(), productsList);

        productsList.sort(Comparator.comparing(Product::getCreateAt).reversed());
        when(productService.getProductsList("create_at-asc")).thenReturn(productsList);
        assertEquals(productService.getProductsList("create_at-asc"), productsList);
    }

    @Test
    void testGetProductsListWithLimit() {
        List<Product> productsList = new ArrayList<>();
        productsList.add(product1);
        productsList.add(product2);

        when(productService.getProductsListWithLimit(2)).thenReturn(productsList);
        assertEquals(productService.getProductsListWithLimit(2), productsList);

        productsList.sort(Comparator.comparing(Product::getCreateAt).reversed());
        when(productService.getProductsListWithLimit(2, "create_at-asc")).thenReturn(productsList);
        assertEquals(productService.getProductsListWithLimit(2, "create_at-asc"), productsList);
    }
}
