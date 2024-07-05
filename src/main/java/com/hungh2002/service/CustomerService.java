package com.hungh2002.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public void signUp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // HttpSession session = request.getSession();
        // String sessionId = session.getId();

        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        params.put("table", "customers");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        params.put("column", "1");
        params.put("condition", "username");
        params.put("username", username);
        params.put("password", password);

        CustomerDAO customerDAO = new CustomerDAO();

        try {
            ResultSet accountEsxists = customerDAO.queryData(params);
            if (accountEsxists.next()) {
                System.out.println("Account already exists");
            } else {
                params.replace("column", "username, password");
                params.remove("condition");
                customerDAO.insertData(params);
            }
        } catch (Exception e) {
            System.out.println("ERROR: ProductService --> SignUp: " + e);
        } finally {
            customerDAO.close();

        }
    }

    public void signIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LinkedHashMap<String, String> params = new LinkedHashMap<>();

        params.put("table", "customers");
        String password = request.getParameter("password");
        params.put("column", "password");
        String username = request.getParameter("username");
        params.put("condition", "username");
        params.put("username", username);

        HttpSession session = request.getSession();

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
            ResultSet data = customerDAO.queryData(params);

            if (data.next()) {
                if (data.getString("password").equals(password)) {
                    session.setAttribute("username", username);
                }
                // if (rememberMe.equals("true")) {
                // Cookie sessionIdCookie = new Cookie("sessionId", data.getString("sessionId"));
                // sessionIdCookie.setMaxAge(60 * 60 * 24 * 365 * 10);
                // sessionIdCookie.setPath("/");
                // response.addCookie(sessionIdCookie);
                // }
            }
        } catch (Exception e) {
            System.out.println("ERROR: CustomerService --> SiginIn: " + e);
        } finally {
            customerDAO.close();
        }
    }

    public void signOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
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
