package com.riode.model.dao;

import com.riode.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class UserDaoImpl implements UserDao{
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getOne(Integer integer) {
        return null;
    }

    @Override
    public boolean updateAndSave(User user) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
