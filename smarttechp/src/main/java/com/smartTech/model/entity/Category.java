package com.smartTech.model.entity;
import javax.validation.constraints.NotEmpty;
public class Category {
    private Integer categoryId;
    @NotEmpty(message = "Name can't be empty")
    private String categoryName;
    private Integer parentId;
    private Byte status = 1;
    public Integer getCategoryId() {
        return categoryId;
    }

    public Category(Integer categoryId, String categoryName, Integer parentId, Byte status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentId = parentId;
        this.status = status;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public Category() {
    }
}
