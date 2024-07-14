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
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.customer.CustomerDAO;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * ProductService
 */
public class CartService {

    public List<Cart> getCartList(long customerId) {
        List<Cart> cartList = null;

        CartDAO cartDAO = new CartDAO();
        try {
            cartList = cartDAO.findByCustomerId(customerId);
        } catch (Exception e) {
            System.out.println(" ProductService --> getCart() :" + e);
        } finally {
            cartDAO.close();
        }

        return cartList;
    }

    public List<Cart> getCart(long productId, long customerId) {
        List<Cart> cartList = new ArrayList<>();

        CartDAO cartDAO = new CartDAO();
        try {
            Cart cart = cartDAO.findByCustomerIdAndProductId(customerId, productId);
            cartList.add(cart);
        } catch (Exception e) {
            System.out.println(" ProductService --> getCart() :" + e);
        } finally {
            cartDAO.close();
        }

        return cartList;
    }

    public void addProductToCart(long productId, long customerId, int quantity) {


        CartDAO cartDAO = new CartDAO();
        ProductDAO productDAO = new ProductDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        try {
            Cart exampleCart = cartDAO.findByCustomerIdAndProductId(customerId, productId);
            if (exampleCart != null) {
                quantity = quantity + exampleCart.getQuantity();
            }

            Product product = productDAO.findById(productId);

            Customer customer = customerDAO.findById(customerId);

            Cart cart = new Cart(product, customer, quantity);
            cartDAO.save(cart);

        } catch (Exception e) {
            System.out.println("ERROR: CartService --> addProductToCart: " + e);
        } finally {
            cartDAO.close();
            productDAO.close();
            customerDAO.close();
        }

    }
}
