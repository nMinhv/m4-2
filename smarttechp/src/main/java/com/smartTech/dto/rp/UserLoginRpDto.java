package com.smartTech.dto.rp;

public class UserLoginRpDto {
    private Integer userId;
    private String userName;
    private String email;
    private String phone;
    private Byte status;
    private Byte role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public UserLoginRpDto(Integer userId, String userName, String email, String phone, Byte status, Byte role) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.role = role;
    }

    public UserLoginRpDto() {
    }
}
