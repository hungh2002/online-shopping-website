package com.hungh2002.controller;

import java.io.IOException;
import java.io.PrintWriter;
import com.hungh2002.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * CustomerController
 */
@WebServlet("/api/customer")
@MultipartConfig
// "request.getParameter(String x);" Normally data can only be obtained from url-param or
// x-www-form-urlencoded. Therefore, if you want to get data from formdata, you must use the
// annotation " @MultipartConfig ".
public class CustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String auth = request.getParameter("auth");

        CustomerService customerService = new CustomerService();
        if (auth.equals("sign-out")) {
            customerService.signOut(session);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        String auth = request.getParameter("auth");
        CustomerService customerService = new CustomerService();

        try (PrintWriter printWriter = response.getWriter()) {
            response.setCharacterEncoding("UTF-8");

            switch (auth) {
                case "sign-up":
                    printWriter.print(customerService.signUp(username, password));
                    break;
                case "sign-in":
                    printWriter.print(customerService.signIn(session, username, password));
                    break;
            }

        } catch (IOException e) {
            System.out.println("ProductController --> Send text Error: " + e);
        }

    }
}
