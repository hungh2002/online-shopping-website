package com.hungh2002.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.hungh2002.model.customer.Customer;
import jakarta.servlet.http.HttpSession;

public class CustomerServiceTest {
        private static Customer customer1 = new Customer(1, "username1", "password1", null);

        private static CustomerService customerService;
        private static HttpSession session;

        @BeforeAll
        public static void setup() {
                customerService = mock(CustomerService.class);

                session = mock(HttpSession.class);
                when(session.getAttribute("customerId"))
                                .thenReturn(String.valueOf(customer1.getCustomerId()));
                when(session.getAttribute("username")).thenReturn(customer1.getUsername());
                doNothing().when(session).removeAttribute("customerId");
                doNothing().when(session).removeAttribute("username");
        }

        @Test
        void testSignIn() {
                when(customerService.signIn(session, customer1.getUsername(), customer1.getPassword()))
                                .thenReturn("Sign in success");

                assertEquals(customerService.signIn(session, "username1", "password1"), "Sign in success");
                assertTrue(session.getAttribute("customerId").equals("1"));
                assertTrue(session.getAttribute("username").equals("username1"));

                when(customerService.signIn(session, "username1", "password1"))
                                .thenReturn("Sign in failed");

                assertEquals(customerService.signIn(session, "username1", "password1"), "Sign in failed");
        }

        @Test
        void testSignUp() {
                when(customerService.signIn(session, "username1", "password1"))
                                .thenReturn("Account already exists");
                assertEquals(customerService.signIn(session, "username1", "password1"),
                                "Account already exists");

                when(customerService.signIn(session, "username1", "password1"))
                                .thenReturn("Account created successfully");
                assertEquals(customerService.signIn(session, "username1", "password1"),
                                "Account created successfully");
        }
}
