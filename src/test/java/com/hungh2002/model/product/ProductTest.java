package com.hungh2002.model.product;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.Timestamp;
import org.junit.jupiter.api.Test;
import com.hungh2002.model.ModelTestInterface;

public class ProductTest implements ModelTestInterface {
    @Override
    @Test
    public void testGet() {
        long productId = 1;
        String name = "name";
        String category = "category";
        double price = 1.2;
        String image = "image";
        Timestamp createAt = new Timestamp(System.currentTimeMillis());

        Product product = new Product(productId, name, category, price, image, createAt);
        assertEquals(productId, product.getProductId());
        assertTrue(name.equals(product.getName()));
        assertTrue(category.equals(product.getCategory()));
        assertEquals(price, product.getPrice());
        assertTrue(image.equals(product.getImage()));
        assertEquals(createAt, product.getCreateAt());
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

        Product product = new Product();
        product.setProductId(productId);
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setImage(image);
        product.setCreateAt(createAt);

        assertEquals(productId, product.getProductId());
        assertTrue(name.equals(product.getName()));
        assertTrue(category.equals(product.getCategory()));
        assertEquals(price, product.getPrice());
        assertTrue(image.equals(product.getImage()));
        assertEquals(createAt, product.getCreateAt());
    }

    @Override
    @Test
    public void testException() {
        long productId = -1;
        String name = "name";
        String category = "category";
        double price = -1.2;
        String image = "image";
        Timestamp createAt = new Timestamp(System.currentTimeMillis());

        assertThrows(IllegalArgumentException.class, () -> {
            new Product(productId, name, category, price, image, createAt);
        });

        Product product = new Product();
        assertThrows(IllegalArgumentException.class, () -> {
            product.setProductId(productId);
            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);
            product.setImage(image);
            product.setCreateAt(createAt);
        });
    }
}
