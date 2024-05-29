package com.hungh2002.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;
import com.hungh2002.service.utils.UrlParam;
import com.hungh2002.service.utils.parameterUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ProductService
 */
public class ProductService {



    public void getNewProducts(HttpServletRequest request, HttpServletResponse response) {

        List<Product> listNewProducts = new ArrayList<>();
        Gson gson = new Gson();
        String orderByColumn = parameterUtils.getParam(request.getParameter("order-by"));
        String sortOrder = parameterUtils.getParam(request.getParameter("sortOrder"));
        String condition = parameterUtils.getParam(request.getParameter("condition"));
        String limit = parameterUtils.getParam(request.getParameter("limit"));



        ProductDAO productDAO = new ProductDAO();
        try (ResultSet data = productDAO.queryData(orderByColumn, sortOrder, condition, limit)) {
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                String category = data.getString("category");
                double price = data.getDouble("price");
                String image = data.getString("image");
                Timestamp createAt = data.getTimestamp("createAt");
                Product product = new Product(id, name, category, price, image, createAt);

                listNewProducts.add(product);
            }
        } catch (Exception e) {
            System.out.println(" ProductService error:" + e);
        }

        String json = gson.toJson(listNewProducts);

        try (PrintWriter printWriter = response.getWriter()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            printWriter.print(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Send Json Error: " + e);
        }
    }
}
