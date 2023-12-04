package com.example.model.dao;

import com.example.model.entity.User;

public interface UserDAO extends IGenericDAO<User,Integer> {
    User login(User user);
}
