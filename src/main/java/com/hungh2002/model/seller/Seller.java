package com.hungh2002.model.seller;

import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.product.Product;

/**
 * Seller
 */
public class Seller {

    private long sellerId;
    private Product product;
    private Customer customer;
    private int quantity;

    public Seller() {}

    public Seller(Product product, Customer customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public Seller(long sellerId, Product product, Customer customer, int quantity) {
        if (sellerId <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }
        this.sellerId = sellerId;
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public long getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(long sellerId) {
        if (sellerId <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }
        this.sellerId = sellerId;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "seller [sellerId=" + sellerId + ", Product [productId=" + product.getProductId()
                + ", name=" + product.getName() + ", category=" + product.getCategory() + ", price="
                + product.getPrice() + ", image=" + product.getImage() + "]" + ", customer="
                + customer + ", Customer [customerId=" + customer.getCustomerId() + ", username="
                + customer.getUsername() + ", password=" + customer.getPassword() + ", sessionId="
                + customer.getSessionId() + "]" + "]";
    }
}
