package com.smartTech.service;

import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.dto.rq.UserLoginRqDto;
import com.smartTech.dto.rq.UserRegisterDto;
import com.smartTech.model.entity.User;

public interface UserService extends IGenericService<User,Integer>{
    User castTo(UserRegisterDto register);
    UserLoginRpDto login(UserLoginRqDto loginRq);

    UserLoginRpDto loginAdmin(UserLoginRqDto loginRq);
}
