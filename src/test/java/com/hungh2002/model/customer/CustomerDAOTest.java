package com.hungh2002.model.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.hungh2002.config.environmentVariable.Env;
import com.hungh2002.model.DAOTestInterface;
import com.hungh2002.model.RefreshTheTable;

public class CustomerDAOTest implements DAOTestInterface {
    public static String table = "customers";

    private static Customer customer1 = new Customer(1, "username1", "password1", null);
    private static Customer customer2 = new Customer(2, "username2", "password2", null);
    private static Customer customer3 = new Customer(3, "username3", "password3", null);
    private static List<Customer> customersList;
    private static List<Customer> sortedCustomersList;

    private static CustomerDAO customerDAO;

    @BeforeAll
    public static void setup() throws SQLException {
        new RefreshTheTable().execute(table, Env.CREATE_CUSTOMER_TABLE_SCRIPT);

        customersList = new ArrayList<>();
        customersList.add(customer1);
        customersList.add(customer2);
        customersList.add(customer3);

        sortedCustomersList = new ArrayList<>(customersList);
        sortedCustomersList.sort(Comparator.comparing(Customer::getUsername));

        customerDAO = new CustomerDAO();
        customerDAO.save(customer1);
        customerDAO.save(customer2);
        customerDAO.save(customer3);
    }

    @AfterAll
    public static void teardown() {
        new RefreshTheTable().dropTable(table);
    }

    @Test
    void testFindByUsername() {
        assertEquals(customerDAO.findByUsername("username2").toString(), customer2.toString());
    }

    @Test
    void testUpdate() {

    }

    @Override
    @Test
    public void testFindAll() {
        List<Customer> foundCustomersList = customerDAO.findAll();
        for (int i = 0; i < foundCustomersList.size(); i++) {
            System.out.println(foundCustomersList.get(i).toString());
            System.out.println(customersList.get(i).toString());
            assertTrue(
                    foundCustomersList.get(i).toString().equals(customersList.get(i).toString()));
        }

        List<Customer> foundCustomersListWithLimit = customerDAO.findAllWithLimit(2);
        for (int i = 0; i < foundCustomersListWithLimit.size(); i++) {
            assertTrue(
                    foundCustomersList.get(i).toString().equals(customersList.get(i).toString()));
        }

        List<Customer> foundCustomersListOrderBy = customerDAO.findAll("username-asc");
        for (int i = 0; i < foundCustomersListOrderBy.size(); i++) {
            assertTrue(
                    foundCustomersList.get(i).toString().equals(customersList.get(i).toString()));
        }

        List<Customer> foundCustomersListOrderByWithLimit =
                customerDAO.findAllWithLimit(2, "username-asc");
        for (int i = 0; i < foundCustomersListOrderByWithLimit.size(); i++) {
            assertTrue(
                    foundCustomersList.get(i).toString().equals(customersList.get(i).toString()));
        }
    }

    @Override
    @Test
    public void testFindById() {
        assertEquals(customerDAO.findById(2).toString(), customer2.toString());
    }

    @Override
    @Test
    public void testExists() {
        assertTrue(customerDAO.exists(" username ", customer2.getUsername()));
    }
}
