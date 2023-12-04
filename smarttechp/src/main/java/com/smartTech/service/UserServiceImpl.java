package com.smartTech.service;

import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.dto.rq.UserLoginRqDto;
import com.smartTech.dto.rq.UserRegisterDto;
import com.smartTech.model.dao.UserDao;
import com.smartTech.model.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
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
        return userDao.updateAndSave(user);
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }


    @Override
    public User castTo(UserRegisterDto registerDto) {
        ModelMapper mapper = new ModelMapper();
        String passwordHash = BCrypt.hashpw(registerDto.getPassword(), BCrypt.gensalt(12));
        registerDto.setPassword(passwordHash);
        return mapper.map(registerDto, User.class);
    }

    @Override
    public UserLoginRpDto login(UserLoginRqDto loginRq) {
        return userDao.login(loginRq);
    }

    @Override
    public UserLoginRpDto loginAdmin(UserLoginRqDto loginRq) {
            UserLoginRpDto rpAdmin = login(loginRq);
            if(rpAdmin != null){
                if(rpAdmin.getRole() == 0){
                    return rpAdmin;
                }
            }
        return null;
    }
}
