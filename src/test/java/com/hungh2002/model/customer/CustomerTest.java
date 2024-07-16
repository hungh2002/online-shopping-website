package com.hungh2002.model.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.hungh2002.model.ModelTestInterface;

public class CustomerTest implements ModelTestInterface {
    @Override
    @Test
    public void testGet() {
        long customerId = 1;
        String username = "username";
        String password = "password";
        String sessionId = null;

        Customer customer1 = new Customer(customerId, username, password, sessionId);
        assertEquals(customerId, customer1.getCustomerId());
        assertTrue(username.equals(customer1.getUsername()));
        assertTrue(password.equals(customer1.getPassword()));
        assertNull(customer1.getSessionId());

        Customer customer2 = new Customer(username, password);
        assertNull(customer1.getCustomerId());
        assertTrue(username.equals(customer2.getUsername()));
        assertTrue(password.equals(customer2.getPassword()));
        assertNull(customer2.getSessionId());
    }

    @Override
    @Test
    public void testSet() {
        long customerId = 1;
        String username = "username";
        String password = "password";
        String sessionId = null;

        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setSessionId(sessionId);

        assertEquals(customerId, customer.getCustomerId());
        assertTrue(username.equals(customer.getUsername()));
        assertTrue(password.equals(customer.getPassword()));
        assertNull(customer.getSessionId());
    }

    @Override
    @Test
    public void testException() {
        long customerId = -1;
        String username = "username";
        String password = "password";
        String sessionId = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(customerId, username, password, sessionId);
        });

        Customer customer = new Customer();
        assertThrows(IllegalArgumentException.class, () -> {
            customer.setCustomerId(customerId);
            customer.setUsername(username);
            customer.setPassword(password);
            customer.setSessionId(sessionId);
        });
    }
}
