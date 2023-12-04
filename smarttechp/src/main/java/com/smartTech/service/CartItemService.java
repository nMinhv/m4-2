package com.smartTech.service;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.model.entity.CartItem;

import java.util.List;

public interface CartItemService{
    List<CartItemDto> cartItems (Integer cartId);
    boolean addToCart(Integer cartId, Integer productId,Integer amount);
    boolean removeCartItem(Integer cartId, Integer pId);
}
