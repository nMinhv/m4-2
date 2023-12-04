package com.smartTech.dto.rq;

import com.smartTech.dto.validation.EmailConstraint;
import com.smartTech.dto.validation.PasswordConstraint;
import com.smartTech.dto.validation.PhoneConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterDto {
    @NotEmpty(message = "Name can't be empty.")
    private String userName;
    @EmailConstraint
    private String email;
    @PasswordConstraint
    private String password;
    @PhoneConstraint
    private String phone;
    public UserRegisterDto() {
    }

    public UserRegisterDto(String userName, String email, String password, String phone) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
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

}
