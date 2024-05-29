package com.hungh2002.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

    public void signUp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> auth = new ArrayList<>();

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        String username = parameterUtils.getParam(request.getParameter("username"));
        String password = parameterUtils.getParam(request.getParameter("password"));
        String condition = "username=? AND password=?";

        auth.add(username);
        auth.add(password);

        CustomerDAO customerDAO = new CustomerDAO();

        try {
            ResultSet data = customerDAO.queryData("", "", condition, auth, "");
            if (data.next()) {
                System.out.println("Account already exists");
            } else {
                customerDAO.insertData(username, password, sessionId);
            }
        } catch (Exception e) {
            System.out.println("ProductService error: " + e);
        } finally {
            customerDAO.close();

        }
    }

    public void signIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = parameterUtils.getParam(request.getParameter("username"));
        String password = parameterUtils.getParam(request.getParameter("password"));
        String rememberMe = parameterUtils.getParam(request.getParameter("rememberMe"));
        String condition = "username=? AND password=?";
        Cookie[] cookies = request.getCookies();
        boolean signInBySessionId = false;

        if (rememberMe.equals("true")) {
            Cookie rememberMeCookie = new Cookie("rememberMe", "true");
            rememberMeCookie.setMaxAge(60 * 60 * 24 * 365 * 10);
            rememberMeCookie.setPath("/");
            response.addCookie(rememberMeCookie);
        }

        List<String> auth = new ArrayList<>();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("rememberMe")) {
                if (cookie.getValue().equals("true")) {
                    condition = "sessionId=?";
                    signInBySessionId = true;
                }
            }
            if (signInBySessionId == true && cookie.getName().equals("sessionId")) {
                auth.add(cookie.getValue());
            }
        }

        if (signInBySessionId == false) {
            auth.add(username);
            auth.add(password);
        }

        CustomerDAO customerDAO = new CustomerDAO();

        try {
            ResultSet data = customerDAO.queryData("", "", condition, auth, "");

            if (data.next()) {
                session.setAttribute("username", data.getString("username"));
                if (rememberMe.equals("true")) {
                    Cookie sessionIdCookie = new Cookie("sessionId", data.getString("sessionId"));
                    sessionIdCookie.setMaxAge(60 * 60 * 24 * 365 * 10);
                    sessionIdCookie.setPath("/");
                    response.addCookie(sessionIdCookie);
                }
            } else {
                System.out.println("Account doesn't exist");
            }
        } catch (Exception e) {
            System.out.println("ProductService error: " + e);
        } finally {
            customerDAO.close();
        }
    }

    public void signOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("username");

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getValue().equals("true")) {
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            if (cookie.getName().equals("sessionId")) {
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}
