package com.smartTech.dto.rq;

import com.smartTech.dto.validation.PasswordConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserLoginRqDto {
    private String userName;
    @NotEmpty(message = "email can't be empty")
    @Email(message = "invalid email")
    private String email;
    @PasswordConstraint
    private String password;

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

    public UserLoginRqDto(String userName, String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginRqDto() {
    }
}
