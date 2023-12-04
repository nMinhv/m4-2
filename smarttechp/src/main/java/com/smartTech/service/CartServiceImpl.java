package com.smartTech.service;

import com.smartTech.model.dao.CartDao;
import com.smartTech.model.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Override
    public Cart getOne(Integer cartId) {
        return cartDao.getOne(cartId);
    }
    @Override
    public boolean updateAndSave(Cart cart) {
        return cartDao.updateAndSave(cart);
    }


}
