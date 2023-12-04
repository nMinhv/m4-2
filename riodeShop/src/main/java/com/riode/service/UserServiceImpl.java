package com.riode.service;
import com.riode.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
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
