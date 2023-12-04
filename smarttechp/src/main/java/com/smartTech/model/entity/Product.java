package com.smartTech.model.entity;

import javax.validation.constraints.*;

public class Product {
    private Integer productId;
    @NotEmpty(message = "Product name can't be empty.")
    private String productName;
    @Positive(message = "Price can't be negative or 0")
    @NotNull(message = "Price can't be empty")
    private Double productPrice;
    @NotEmpty(message = "Description can't be empty.")
    private String des;
    @Positive(message = "Stock can't be negative or 0.")
    @NotNull(message = "Stock can't be empty")
    private Integer stock;

    private Byte status = 1;

    private Integer category_id;
    private String previewImg;

    public String getPreviewImg() {
        return previewImg;
    }

    public void setPreviewImg(String previewImg) {
        this.previewImg = previewImg;
    }

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

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Product() {
    }

    public Product(Integer productId, String productName, Double productPrice, String des, Integer stock, Byte status, Integer category_id, String previewImg) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.des = des;
        this.stock = stock;
        this.status = status;
        this.category_id = category_id;
        this.previewImg = previewImg;
    }
}
