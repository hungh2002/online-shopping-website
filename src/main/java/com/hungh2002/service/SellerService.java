package com.hungh2002.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hungh2002.model.seller.Seller;
import com.hungh2002.model.seller.SellerDAO;
import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.customer.CustomerDAO;
import com.hungh2002.model.product.Product;
import com.hungh2002.model.product.ProductDAO;

/**
 * ProductService
 */
public class SellerService {

    public List<Seller> getSellerList(long customerId) {
        List<Seller> sellerList = null;

        SellerDAO sellerDAO = null;
        sellerDAO = new SellerDAO();
        try {
            sellerList = sellerDAO.findByCustomerId(customerId);
        } catch (Exception e) {
            System.out.println(" ProductService --> getSeller() :" + e);
        } finally {
            sellerDAO.close();
        }

        return sellerList;
    }

    public List<Seller> getSeller(long productId, long customerId) {
        List<Seller> sellerList = new ArrayList<>();

        SellerDAO sellerDAO = null;
        sellerDAO = new SellerDAO();
        try {
            Seller seller = sellerDAO.findByCustomerIdAndProductId(customerId, productId);
            sellerList.add(seller);
        } catch (Exception e) {
            System.out.println(" ProductService --> getSeller() :" + e);
        } finally {
            sellerDAO.close();
        }

        return sellerList;
    }

    public void addProductToSeller(long productId, long customerId, int quantity) {

        SellerDAO sellerDAO = null;
        ProductDAO productDAO = null;
        CustomerDAO customerDAO = null;
        sellerDAO = new SellerDAO();
        productDAO = new ProductDAO();
        customerDAO = new CustomerDAO();
        try {
            Seller exampleSeller = sellerDAO.findByCustomerIdAndProductId(customerId, productId);
            if (exampleSeller != null) {
                quantity = quantity + exampleSeller.getQuantity();
            }

            Product product = productDAO.findById(productId);

            Customer customer = customerDAO.findById(customerId);

            Seller seller = new Seller(product, customer, quantity);
            sellerDAO.save(seller);

        } catch (Exception e) {
            System.out.println("ERROR: SellerService --> addProductToSeller: " + e);
        } finally {
            sellerDAO.close();
            productDAO.close();
            customerDAO.close();
        }

    }
}

