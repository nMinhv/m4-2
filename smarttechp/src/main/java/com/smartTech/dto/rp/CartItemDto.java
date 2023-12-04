package com.smartTech.dto.rp;

public class CartItemDto {
    private Integer cart_id;
    private Integer product_id;
    private Integer quantity;
    private Double sub_price;
    private String productName;
    private String previewImg;
    private Double productPrice;
    private Integer stock;

    public CartItemDto() {
    }

    public CartItemDto(Integer cart_id, Integer product_id, Integer quantity, Double sub_price, String productName, String previewImg, Double productPrice, Integer stock) {
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.sub_price = sub_price;
        this.productName = productName;
        this.previewImg = previewImg;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSub_price() {
        return sub_price;
    }

    public void setSub_price(Double sub_price) {
        this.sub_price = sub_price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPreviewImg() {
        return previewImg;
    }

    public void setPreviewImg(String previewImg) {
        this.previewImg = previewImg;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
