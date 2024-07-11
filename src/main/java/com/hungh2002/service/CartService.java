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
import com.hungh2002.model.cart.Cart;
import com.hungh2002.model.cart.CartDAO;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * ProductService
 */
public class CartService {

    public void getCart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {

            LinkedHashMap<String, String> params = new LinkedHashMap<>();

            params.put("table", "cart");
            String column = request.getParameter("column");
            params.put("column", column);

            String orderBy = request.getParameter("order-by");
            params.put("order-by", orderBy);

            String customerId = (String) session.getAttribute("customer-id");
            if (customerId != null) {
                params.put("condition", "customer_id");
            }
            params.put("customer-id", customerId);

            String limit = request.getParameter("limit");
            params.put("limit", limit);

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

            CartDAO cartDAO = new CartDAO();
            ProductDAO productDAO = new ProductDAO();

            LinkedHashMap<String, String> productMap = new LinkedHashMap<>();
            productMap.put("table", "products");
            productMap.put("column", null);
            productMap.put("condition", "product_id");
            productMap.put("product-id", null);

            List<Cart> listCart = new ArrayList<>();

            try {
                ResultSet data = cartDAO.queryData(params);

                while (data.next()) {
                    int cartId = data.getInt("cart_id");
                    String productId = data.getString("product_id");
                    Product product = new Product();

                    try {
                        productMap.replace("product-id", productId);
                        ResultSet productData = productDAO.queryData(productMap);

                        product.setId(productData.getInt("product_id"));
                        product.setName(productData.getString("name"));
                        product.setCategory(productData.getString("category"));
                        product.setPrice(productData.getDouble("price"));
                        product.setImage(productData.getString("image"));
                        product.setCreateAt(data.getTimestamp("create_at"));
                    } catch (Exception e) {
                        System.out.println(" ProductService --> Product error:" + e);
                    }

                    listCart.add(new Cart(cartId, null, product, data.getInt("quantity")));
                }
            } catch (Exception e) {
                System.out.println(" ProductService error:" + e);
            } finally {
                productDAO.close();
                cartDAO.close();
            }

            String json = gson.toJson(listCart);

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
}
