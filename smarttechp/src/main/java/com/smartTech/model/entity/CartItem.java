package com.smartTech.model.entity;

public class CartItem {
    private Integer cart_id;
    private Integer product_id;
    private Integer quantity;
    private Double sub_price;

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

    public CartItem(Integer cart_id, Integer product_id, Integer quantity, Double sub_price) {
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.sub_price = sub_price;
    }

    public CartItem() {
    }
}
