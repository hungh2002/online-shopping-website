package com.hungh2002.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hungh2002.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ProductController
 */
@WebServlet("/api/product")
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productId = request.getParameter("product-id");
        String orderBy = request.getParameter("order-by");
        String limit = request.getParameter("limit");

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        ProductService productService = new ProductService();
        String json = null;
        if (productId != null) {
            json = gson.toJson(productService.getProduct(Long.parseLong(productId)));
        } else if (limit != null) {
            json = gson.toJson(
                    productService.getProductsListWithLimit(Integer.parseInt(limit), orderBy));
        } else {
            json = gson.toJson(productService.getProductsList(orderBy));
        }

        try (PrintWriter printWriter = response.getWriter()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            printWriter.print(json);
        } catch (IOException e) {
            System.out.println("ProductController --> Send Json Error: " + e);
        }
    }
}
