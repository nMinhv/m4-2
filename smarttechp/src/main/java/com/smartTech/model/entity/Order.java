package com.smartTech.model.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

public class Order {
    private Integer order_Id;
    private Integer user_id;
    private Integer total_qty;
    private Double total_price;
    @NotEmpty
    @Size(min = 10, max = 15,message = "Invalid phone")
    private String phone;
    @NotEmpty
    private String address;
    @Email(message = "invalid Email")
    @NotEmpty
    private String email;
    @NotEmpty
    private String name;
    private Date date;
    private boolean status;
    public Order() {
    }

    public Order(Integer order_Id, Integer user_id, Integer total_qty, Double total_price, String phone, String address, String email, String name, Date date, boolean status) {
        this.order_Id = order_Id;
        this.user_id = user_id;
        this.total_qty = total_qty;
        this.total_price = total_price;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Integer order_Id) {
        this.order_Id = order_Id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTotal_qty() {
        return total_qty;
    }

    public void setTotal_qty(Integer total_qty) {
        this.total_qty = total_qty;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
