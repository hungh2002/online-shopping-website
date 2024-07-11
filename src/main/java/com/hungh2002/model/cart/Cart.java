package com.hungh2002.model.cart;

import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.product.Product;

/**
 * Cart
 */
public class Cart {

    private int id;
    private Customer customer;
    private Product product;
    private int quantity;

    public Cart() {}


    public Cart(int id, Customer customer, Product product, int quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
