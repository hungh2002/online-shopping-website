package com.hungh2002.controller;

import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hungh2002.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ProductController
 */
@WebServlet("/api/cart")
@MultipartConfig

public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String customerId = request.getParameter("customer-id");
        String productId = request.getParameter("product-id");

        CartService cartService = new CartService();
        Gson gson = new Gson();
        String json = null;

        if (productId != null) {
            json = gson.toJson(
                    cartService.getCart(Long.parseLong(productId), Long.parseLong(customerId)));
        } else {
            json = gson.toJson(cartService.getCartList(Long.parseLong(customerId)));
        }

        try (PrintWriter printWriter = response.getWriter()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            printWriter.print(json);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Send Json Error: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String customerId = request.getParameter("customer-id");
        String productId = request.getParameter("product-id");
        String quantity = request.getParameter("quantity");

        CartService cartService = new CartService();
        cartService.addProductToCart(Long.parseLong(productId), Long.parseLong(customerId),
                Integer.parseInt(quantity));
    }
}
