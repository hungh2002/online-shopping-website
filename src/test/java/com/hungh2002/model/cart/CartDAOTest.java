package com.hungh2002.model.cart;

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

public class CartDAOTest implements DAOTestInterface {
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

        private static String cartTable = "cart";
        private static Cart cart1 = new Cart(1, product1, customer1, 3);
        private static Cart cart2 = new Cart(2, product2, customer2, 2);
        private static Cart cart3 = new Cart(3, product3, customer3, 1);
        private static List<Cart> cartList;

        private static ProductDAO productDAO;
        private static CustomerDAO customerDAO;
        private static CartDAO cartDAO;

        @BeforeAll
        public static void setupProductTable() throws SQLException {
                new RefreshTheTable().execute(productTable, Env.createProductsTableScript);

                productDAO = new ProductDAO();
                productDAO.save(product1);
                productDAO.save(product2);
                productDAO.save(product3);
        }

        @BeforeAll
        public static void setupCustomerTable() throws SQLException {
                new RefreshTheTable().execute(customerTable, Env.createCustomersTableScript);

                customerDAO = new CustomerDAO();
                customerDAO.save(customer1);
                customerDAO.save(customer2);
                customerDAO.save(customer3);
        }

        @BeforeAll
        public static void setupCartTable() throws SQLException {
                new RefreshTheTable().execute(cartTable, Env.createCartTableScript);

                cartList = new ArrayList<>();
                cartList.add(cart1);
                cartList.add(cart2);
                cartList.add(cart3);

                cartDAO = new CartDAO();
                cartDAO.save(cart1);
                cartDAO.save(cart2);
                cartDAO.save(cart3);
        }

        @AfterAll
        public static void teardown() throws SQLException {
                RefreshTheTable refreshTheTable = new RefreshTheTable();
                refreshTheTable.dropTable(productTable);
                refreshTheTable.dropTable(customerTable);
                refreshTheTable.dropTable(cartTable);
        }

        @Test
        public void testExists() {

        }

        @Test
        void testFindByCustomerId() {
                List<Cart> list = new ArrayList<>();
                list.add(cart2);

                List<Cart> foundCartList = cartDAO.findByCustomerId(customer2.getCustomerId());
                for (int i = 0; i < foundCartList.size(); i++) {
                        assertTrue(foundCartList.get(i).toString().equals(list.get(i).toString()));
                }
        }

        @Test
        void testFindByCustomerIdAndProductId() {
                assertTrue(cartDAO.findByCustomerIdAndProductId(customer2.getCustomerId(),
                                product2.getProductId()).toString().equals(cart2.toString()));
        }

        @Test
        void testUpdate() {

        }

        @Override
        public void testFindAll() {
                List<Cart> foundCartList = cartDAO.findAll();
                for (int i = 0; i < foundCartList.size(); i++) {
                        assertTrue(foundCartList.get(i).toString()
                                        .equals(cartList.get(i).toString()));
                }

                List<Cart> foundCartListWithLimit = cartDAO.findAllWithLimit(2);
                for (int i = 0; i < foundCartListWithLimit.size(); i++) {
                        assertTrue(foundCartListWithLimit.get(i).toString()
                                        .equals(foundCartListWithLimit.get(i).toString()));
                }
        }

        @Override
        public void testFindById() {
                assertEquals(cartDAO.findById(cart2.getCartId()).toString(), cart2.toString());
        }
}
