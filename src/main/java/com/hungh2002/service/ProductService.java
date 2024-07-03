package com.hungh2002.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;
import com.hungh2002.service.utils.jspUtils.JsonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ProductService
 */
public class ProductService {

    public void getProduct(HttpServletRequest request, HttpServletResponse response) {

        LinkedHashMap<String, String> params = new LinkedHashMap<>();

        params.put("table", "products");
        String column = request.getParameter("column");
        params.put("column", column);

        String orderBy = request.getParameter("order-by");
        params.put("order-by", orderBy);

        String productId = request.getParameter("product-id");
        if (productId != null) {
            params.put("condition", "product_id");
        }
        params.put("product-id", productId);

        String limit = request.getParameter("limit");
        params.put("limit", limit);

        List<Product> listNewProducts = new ArrayList<>();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        ProductDAO productDAO = new ProductDAO();
        try (ResultSet data = productDAO.queryData(params)) {
            while (data.next()) {
                int id = data.getInt("product_id");
                String name = data.getString("name");
                String category = data.getString("category");
                double price = data.getDouble("price");
                String image = data.getString("image");
                Timestamp createAt = data.getTimestamp("create_at");
                Product product = new Product(id, name, category, price, image, createAt);

                listNewProducts.add(product);
            }
        } catch (Exception e) {
            System.out.println(" ProductService error:" + e);
        } finally {
            productDAO.close();
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
