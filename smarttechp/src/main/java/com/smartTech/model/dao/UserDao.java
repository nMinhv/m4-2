package com.smartTech.model.dao;

import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.dto.rq.UserLoginRqDto;
import com.smartTech.model.entity.User;

import java.util.List;

public interface UserDao extends IGenericDAO<User,Integer> {
    UserLoginRpDto login(UserLoginRqDto loginRq);
    List<String> uniqueList(String col);
}
