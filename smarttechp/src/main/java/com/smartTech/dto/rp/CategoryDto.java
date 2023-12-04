package com.smartTech.dto.rp;

public class CategoryDto {
    private Integer categoryId;
    private String categoryName;
    private String parentName;
    private Integer parentId;
    private Byte status;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public CategoryDto(Integer categoryId, String categoryName, String parentName, Integer parentId, Byte status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentName = parentName;
        this.parentId = parentId;
        this.status = status;
    }

    public CategoryDto() {
    }
}
