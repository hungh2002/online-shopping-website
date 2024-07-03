package com.hungh2002.controller;

import java.io.IOException;
import com.hungh2002.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        String auth = request.getParameter("auth");
        CustomerService customerService = new CustomerService();
        if (auth.equals("sign-out")) {
            customerService.signOut(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Send to logical processor (service)

        String auth = request.getParameter("auth");
        CustomerService customerService = new CustomerService();

        switch (auth) {
            case "sign-up":
                customerService.signUp(request, response);
                break;
            case "sign-in":
                customerService.signIn(request, response);
                break;
        }
    }
}
