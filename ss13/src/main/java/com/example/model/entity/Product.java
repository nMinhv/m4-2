package com.example.model.entity;

public class Product {
    private Integer productId;
    private String productName;
    private Double price;
    private String image;
    private Category category;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(Integer productId, String productName, Double price, String image, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Product() {
    }
}
