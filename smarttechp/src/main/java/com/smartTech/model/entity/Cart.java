package com.smartTech.model.entity;

public class Cart {
    private Integer cart_id;
    private Integer user_id;
    private Integer total_quantity;
    private Double total_price;

    public Cart() {
    }

    public Cart(Integer cart_id, Integer user_id, Integer total_quantity, Double total_price) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.total_quantity = total_quantity;
        this.total_price = total_price;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(Integer total_quantity) {
        this.total_quantity = total_quantity;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }
}
