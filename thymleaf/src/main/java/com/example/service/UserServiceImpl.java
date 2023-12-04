package com.example.service;

import com.example.model.dao.UserDAO;
import com.example.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Boolean updateAndSave(User user) {
        return userDAO.updateAndSave(user);
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public Boolean delete(Integer integer) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User login(User user) {
        return userDAO.login(user);
    }
}
