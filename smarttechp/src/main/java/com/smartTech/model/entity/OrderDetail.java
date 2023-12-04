package com.smartTech.model.entity;

public class OrderDetail {
    private Integer order_id;
    private Integer product_id;
    private Integer quantity;
    private Double sub_price;

    public OrderDetail() {
    }


    public OrderDetail(Integer order_id, Integer product_id, Integer quantity, Double sub_price) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.sub_price = sub_price;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
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
}
