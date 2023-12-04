package com.example.service;

import com.example.model.entity.User;

public interface UserService extends IGenericService <User,Integer> {
    User login(User user);
}
