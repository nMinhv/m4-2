package com.smartTech.service;

import com.smartTech.model.entity.Cart;

public interface CartService {

    Cart getOne(Integer userId);

    boolean updateAndSave(Cart cart);

}
