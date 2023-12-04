package com.smartTech.model.dao;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.model.entity.Cart;
import com.smartTech.model.entity.CartItem;

import java.util.List;

public interface CartItemDao {
        List<CartItemDto> cartItems (Integer cartId);
        CartItem cartItem(Integer cartId, Integer pId);
        boolean saveCartItem(CartItem cartItem , String action);
        boolean removeCartItem(Integer cartId, Integer pId);
}
