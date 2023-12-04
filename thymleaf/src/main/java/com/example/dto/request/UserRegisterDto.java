package com.example.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterDto {
    @NotNull(message = "ten khong duoc de rong")
    private String userName;
    @Email(message = "sai dinh dang")
    private String email;
    @Size(min = 8,max = 20, message = "sai cmnr")
    private String password;
    private String phone;
    private Boolean role = true;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public UserRegisterDto(String userName, String email, String password, String phone, Boolean role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public UserRegisterDto() {
    }
}
