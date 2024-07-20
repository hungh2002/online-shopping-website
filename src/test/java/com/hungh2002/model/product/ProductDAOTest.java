package com.hungh2002.model.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.hungh2002.config.environmentVariable.Env;
import com.hungh2002.model.DAOTestInterface;
import com.hungh2002.model.RefreshTheTable;

public class ProductDAOTest implements DAOTestInterface {
    private static String table = "products";

    private static Product product1 = new Product(1, "name1", "category1", 1.1, "image1",
            new Timestamp(System.currentTimeMillis()));
    private static Product product2 = new Product(2, "name2", "category2", 2.2, "image2",
            new Timestamp(System.currentTimeMillis()));
    private static Product product3 = new Product(3, "name3", "category3", 3.3, "image3",
            new Timestamp(System.currentTimeMillis()));
    private static List<Product> productsList;
    private static List<Product> sortedProductsList;

    private static ProductDAO productDAO;

    @BeforeAll
    public static void setup() throws SQLException {
        new RefreshTheTable().execute(table, Env.CREATE_PRODUCTS_TABLE_SCRIPT);

        productDAO = new ProductDAO();
        productDAO.save(product1);
        productDAO.save(product2);
        productDAO.save(product3);

        productsList = new ArrayList<>();
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);

        sortedProductsList = new ArrayList<>(productsList);
        sortedProductsList.sort(Comparator.comparing(Product::getCreateAt).reversed());
    }

    @AfterAll
    public static void teardown() {
        new RefreshTheTable().dropTable(table);
    }

    @Override
    @Test
    public void testFindAll() {

        List<Product> foundProductsList = productDAO.findAll();
        for (int i = 0; i < foundProductsList.size(); i++) {
            assertTrue(foundProductsList.get(i).toString().equals(productsList.get(i).toString()));
        }

        List<Product> foundProductsListWithLimit = productDAO.findAllWithLimit(2);
        for (int i = 0; i < foundProductsListWithLimit.size(); i++) {
            assertTrue(foundProductsList.get(i).toString().equals(productsList.get(i).toString()));
        }

        List<Product> foundProductsListOrderBy = productDAO.findAll("create_at-asc");
        for (int i = 0; i < foundProductsListOrderBy.size(); i++) {
            assertTrue(foundProductsList.get(i).toString()
                    .equals(sortedProductsList.get(i).toString()));
        }

        List<Product> foundProductsListOrderByWithLimit =
                productDAO.findAllWithLimit(2, "create_at-asc");
        for (int i = 0; i < foundProductsListOrderByWithLimit.size(); i++) {
            assertTrue(foundProductsList.get(i).toString()
                    .equals(sortedProductsList.get(i).toString()));
        }
    }

    @Override
    @Test
    public void testExists() {
        assertTrue(productDAO.exists(" name ", product1.getName()));
    }

    @Override
    @Test
    public void testFindById() {
        assertEquals(productDAO.findById(product2.getProductId()).toString(), product2.toString());
    }
}
