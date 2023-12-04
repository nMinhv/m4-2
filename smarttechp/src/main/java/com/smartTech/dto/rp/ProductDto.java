package com.smartTech.dto.rp;
import javax.validation.constraints.*;

public class ProductDto {
    private Integer productId;
    private String productName;
    private Double productPrice;
    private String des;
    private Integer stock;
    private Byte status;
    private Integer category_id;
    private String category_name;
    private String previewImg;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

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

    public ProductDto() {
    }

    public ProductDto(Integer productId, String productName, Double productPrice, String des, Integer stock, Byte status, Integer category_id, String category_name, String previewImg) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.des = des;
        this.stock = stock;
        this.status = status;
        this.category_id = category_id;
        this.category_name = category_name;
        this.previewImg = previewImg;
    }
}