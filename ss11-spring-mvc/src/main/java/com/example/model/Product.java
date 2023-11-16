package com.example.model;

public class Product {
    private Integer productId;
    private String pName;
    private float Price;
    private String imgURL;
    private String des;
    private Integer categoryId;

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Product(Integer productId, String pName, float price, String imgURL, String des, Integer categoryId) {
        this.productId = productId;
        this.pName = pName;
        this.Price = price;
        this.imgURL = imgURL;
        this.des = des;
        this.categoryId = categoryId;
    }

    public Product(Integer productId, String pName, float price) {
        this.productId = productId;
        this.pName = pName;
        Price = price;
    }
}
