package com.hungh2002.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;

/**
 * ProductService
 */
public class ProductService {

    public List<Product> getProduct(long productId) {
        List<Product> productsList = new ArrayList<>();
        ProductDAO productDAO = null;
        try {
            productDAO = new ProductDAO();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Product product = productDAO.findById(productId);
            productsList.add(product);
        } catch (Exception e) {
            System.out.println(" ProductService --> getProduct() : " + e);
        } finally {
            productDAO.close();
        }

        return productsList;
    }

    public List<Product> getProductsList(String orderBy) {
        List<Product> productsList = null;
        ProductDAO productDAO = null;
        try {
            productDAO = new ProductDAO();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if (orderBy != null) {
                productsList = productDAO.findAll(orderBy);
            } else {
                productsList = productDAO.findAll();
            }
        } catch (Exception e) {
            System.out.println(" ProductService --> getProductsList() : " + e);
        } finally {
            productDAO.close();
        }

        return productsList;
    }

    public List<Product> getProductsList() {
        return getProductsList(null);
    }

    public List<Product> getProductsListWithLimit(int limit, String orderBy) {

        List<Product> productsList = null;
        ProductDAO productDAO = null;
        try {
            productDAO = new ProductDAO();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if (orderBy != null) {
                productsList = productDAO.findAllWithLimit(limit, orderBy);
            } else {
                productsList = productDAO.findAllWithLimit(limit);
            }
        } catch (Exception e) {
            System.out.println(" ProductService --> getProductsListWithLimit() : " + e);
        } finally {
            productDAO.close();
        }

        return productsList;
    }

    public List<Product> getProductsListWithLimit(int limit) {
        return getProductsListWithLimit(limit, null);
    }
}
