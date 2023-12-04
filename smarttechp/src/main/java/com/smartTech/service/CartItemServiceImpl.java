package com.smartTech.service;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.model.dao.CartItemDao;
import com.smartTech.model.entity.Cart;
import com.smartTech.model.entity.CartItem;
import com.smartTech.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemDao cartItemDao;
    @Autowired
    private ProductService productService;

    @Override
    public List<CartItemDto> cartItems(Integer cartId) {
        return cartItemDao.cartItems(cartId);
    }

    @Override
    public boolean addToCart(Integer cartId, Integer productId, Integer amount) {
        CartItem cartItem = cartItemDao.cartItem(cartId, productId);
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setCart_id(cartId);
            cartItem.setProduct_id(productId);
            cartItem.setQuantity(amount);
            return cartItemDao.saveCartItem(cartItem, "add");
        } else {
            cartItem.setQuantity(amount);
            return cartItemDao.saveCartItem(cartItem, "update");
        }
    }
    @Override
    public boolean removeCartItem(Integer cartId, Integer pId) {
        return cartItemDao.removeCartItem(cartId,pId);
    }

}
