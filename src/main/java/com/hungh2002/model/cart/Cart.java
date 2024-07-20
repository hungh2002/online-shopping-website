package com.hungh2002.model.cart;

import com.hungh2002.model.customer.Customer;
import com.hungh2002.model.product.Product;

/**
 * Cart
 */
public class Cart {

    private long cartId;
    private Product product;
    private Customer customer;
    private int quantity;

    public Cart() {}

    public Cart(Product product, Customer customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public Cart(long cartId, Product product, Customer customer, int quantity) {
        if (cartId <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }
        this.cartId = cartId;
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public long getCartId() {
        return this.cartId;
    }

    public void setCartId(long cartId) {
        if (cartId <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }
        this.cartId = cartId;
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
        return "Cart [cartId=" + cartId + ", Product [productId=" + product.getProductId()
                + ", name=" + product.getName() + ", category=" + product.getCategory() + ", price="
                + product.getPrice() + ", image=" + product.getImage() + "]" + ", customer="
                + customer + ", Customer [customerId=" + customer.getCustomerId() + ", username="
                + customer.getUsername() + ", password=" + customer.getPassword() + ", sessionId="
                + customer.getSessionId() + "]" + "]";
    }
}
