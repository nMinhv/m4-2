package com.example.model;

public class Category {
    private Integer categoryId;
    private String categoryName;
    private String des;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, String des) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.des = des;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
