package com.hungh2002.model.seller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.hungh2002.config.environmentVariable.Env;
import com.hungh2002.model.DAOTestInterface;
import com.hungh2002.model.RefreshTheTable;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.customer.CustomerDAO;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;

public class SellerDAOTest implements DAOTestInterface {
    private static String productTable = "products";
    private static Product product1 = new Product(1, "name1", "category1", 1.1, "image1",
            new Timestamp(System.currentTimeMillis()));
    private static Product product2 = new Product(2, "name2", "category2", 2.2, "image2",
            new Timestamp(System.currentTimeMillis()));
    private static Product product3 = new Product(3, "name3", "category3", 3.3, "image3",
            new Timestamp(System.currentTimeMillis()));

    public static String customerTable = "customers";
    private static Customer customer1 = new Customer(1, "username1", "password1", null);
    private static Customer customer2 = new Customer(2, "username2", "password2", null);
    private static Customer customer3 = new Customer(3, "username3", "password3", null);

    private static String sellerTable = "sellers";
    private static Seller seller1 = new Seller(1, product1, customer1, 3);
    private static Seller seller2 = new Seller(2, product2, customer2, 2);
    private static Seller seller3 = new Seller(3, product3, customer3, 1);
    private static List<Seller> sellersList;

    private static ProductDAO productDAO;
    private static CustomerDAO customerDAO;
    private static SellerDAO sellerDAO;

    @BeforeAll
    public static void setupProductTable() throws SQLException {
        new RefreshTheTable().execute(productTable, Env.CREATE_PRODUCTS_TABLE_SCRIPT);

        productDAO = new ProductDAO();
        productDAO.save(product1);
        productDAO.save(product2);
        productDAO.save(product3);
    }

    @BeforeAll
    public static void setupCustomerTable() throws SQLException {
        new RefreshTheTable().execute(customerTable, Env.CREATE_CUSTOMER_TABLE_SCRIPT);

        customerDAO = new CustomerDAO();
        customerDAO.save(customer1);
        customerDAO.save(customer2);
        customerDAO.save(customer3);
    }

    @BeforeAll
    public static void setupSellerTable() throws SQLException {
        new RefreshTheTable().execute(sellerTable, Env.CREATE_SELLERS_TABLE_SCRIPT);

        sellersList = new ArrayList<>();
        sellersList.add(seller1);
        sellersList.add(seller2);
        sellersList.add(seller3);

        sellerDAO = new SellerDAO();
        sellerDAO.save(seller1);
        sellerDAO.save(seller2);
        sellerDAO.save(seller3);
    }

    @AfterAll
    public static void teardown() throws SQLException {
        RefreshTheTable refreshTheTable = new RefreshTheTable();
        refreshTheTable.dropTable(productTable);
        refreshTheTable.dropTable(customerTable);
        refreshTheTable.dropTable(sellerTable);
    }

    @Test
    public void testExists() {

    }

    @Test
    void testFindByCustomerId() {
        List<Seller> list = new ArrayList<>();
        list.add(seller2);

        List<Seller> foundSellerList = sellerDAO.findByCustomerId(customer2.getCustomerId());
        for (int i = 0; i < foundSellerList.size(); i++) {
            assertTrue(foundSellerList.get(i).toString().equals(list.get(i).toString()));
        }
    }

    @Test
    void testFindByCustomerIdAndProductId() {
        assertTrue(sellerDAO
                .findByCustomerIdAndProductId(customer2.getCustomerId(), product2.getProductId())
                .toString().equals(seller2.toString()));
    }

    @Test
    void testUpdate() {

    }

    @Override
    public void testFindAll() {
        List<Seller> foundSellerList = sellerDAO.findAll();
        for (int i = 0; i < foundSellerList.size(); i++) {
            assertTrue(foundSellerList.get(i).toString().equals(sellersList.get(i).toString()));
        }

        List<Seller> foundSellerListWithLimit = sellerDAO.findAllWithLimit(2);
        for (int i = 0; i < foundSellerListWithLimit.size(); i++) {
            assertTrue(foundSellerListWithLimit.get(i).toString()
                    .equals(foundSellerListWithLimit.get(i).toString()));
        }
    }

    @Override
    public void testFindById() {
        assertEquals(sellerDAO.findById(seller2.getSellerId()).toString(), seller2.toString());
    }
}

