package com.hungh2002.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.customer.CustomerDAO;
import com.hungh2002.service.utils.parameterUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * CustomerService
 */
public class CustomerService {

    public String signUp(String username, String password) {
        Customer customer = null;
        String status = null;
        // HttpSession session = request.getSession();
        // String sessionId = session.getId();

        CustomerDAO customerDAO = new CustomerDAO();
        try {
            if (customerDAO.exists("username", username) == true) {
                status = "Account already exists";
            } else {
                customerDAO.save(new Customer(username, password));
                status = "Account created successfully";
            }
        } catch (Exception e) {
            System.out.println("ERROR: customerService --> SignUp() : " + e);
        } finally {
            customerDAO.close();
        }
        return status;
    }

    public String signIn(HttpSession session, String username, String password) {
        Customer customer = null;
        String status = null;

        // String rememberMe = parameterUtils.getParam(request.getParameter("rememberMe"));
        // Cookie[] cookies = request.getCookies();
        // boolean signInBySessionId = false;

        // if (rememberMe.equals("true")) {
        // Cookie rememberMeCookie = new Cookie("rememberMe", "true");
        // rememberMeCookie.setMaxAge(60 * 60 * 24 * 365 * 10);
        // rememberMeCookie.setPath("/");
        // response.addCookie(rememberMeCookie);
        // }

        // List<String> auth = new ArrayList<>();

        // for (Cookie cookie : cookies) {
        // if (cookie.getName().equals("rememberMe")) {
        // if (cookie.getValue().equals("true")) {
        // condition = "sessionId=?";
        // signInBySessionId = true;
        // }
        // }
        // if (signInBySessionId == true && cookie.getName().equals("sessionId")) {
        // auth.add(cookie.getValue());
        // }
        // }

        // if (signInBySessionId == false) {
        // auth.add(username);
        // auth.add(password);
        // }

        CustomerDAO customerDAO = new CustomerDAO();
        try {
            customer = customerDAO.findByUsername(username);

            if (customer.getPassword().equals(password)) {
                session.setAttribute("customerId", customer.getCustomerId());
                session.setAttribute("username", customer.getUsername());
                status = "Sign in success";

                // if (rememberMe.equals("true")) {
                // Cookie sessionIdCookie = new Cookie("sessionId", data.getString("sessionId"));
                // sessionIdCookie.setMaxAge(60 * 60 * 24 * 365 * 10);
                // sessionIdCookie.setPath("/");
                // response.addCookie(sessionIdCookie);
                // }
            } else {
                status = "Sign in failed";
            }
        } catch (Exception e) {
            System.out.println("ERROR: CustomerService --> SignIn() : " + e);
        } finally {
            customerDAO.close();
        }

        return status;
    }

    public void signOut(HttpSession session) {

        session.removeAttribute("username");

        // Cookie[] cookies = request.getCookies();

        // for (Cookie cookie : cookies) {
        // if (cookie.getValue().equals("true")) {
        // cookie.setPath("/");
        // cookie.setMaxAge(0);
        // response.addCookie(cookie);
        // }
        // if (cookie.getName().equals("sessionId")) {
        // cookie.setPath("/");
        // cookie.setMaxAge(0);
        // response.addCookie(cookie);
        // }
        // }
    }
}
