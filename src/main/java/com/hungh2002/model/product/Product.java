package com.hungh2002.model.product;

import java.sql.Timestamp;

/**
 * Product
 */
public class Product {

    private long productId;
    private String name;
    private String category;
    private double price;
    private String image;
    private Timestamp createAt;

    public Product() {}


    public Product(long productId, String name, String category, double price, String image,
            Timestamp createAt) {

        if (productId <= 0 || price <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }

        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
        this.createAt = createAt;
    }


    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }
        this.productId = productId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }


    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + ", category=" + category
                + ", price=" + price + ", image=" + image + "]";
    }



}
