package com.smartTech.model.dao;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.model.entity.Cart;
import com.smartTech.model.entity.CartItem;
import com.smartTech.util.ConnectionDataBase;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartItemDaoImpl implements CartItemDao {
    @Override
    public List<CartItemDto> cartItems(Integer cartId) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL GET_CART_ITEMS_PROC(?)";
        List<CartItemDto> cartItems = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, cartId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CartItemDto cartItem = new CartItemDto();
                cartItem.setCart_id(rs.getInt("cart_id"));
                cartItem.setProduct_id(rs.getInt("product_id"));
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItem.setSub_price(rs.getDouble("sub_price"));
                cartItem.setProductName(rs.getString("productName"));
                cartItem.setPreviewImg(rs.getString("previewImg"));
                cartItem.setProductPrice(rs.getDouble("productPrice"));
                cartItem.setStock(rs.getInt("stock"));
                cartItems.add(cartItem);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return cartItems;
    }

    @Override
    public CartItem cartItem(Integer cartId, Integer pId) {
        CartItem cartItem = new CartItem();
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL GET_CART_ITEM_PROC(?,?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, cartId);
            cs.setInt(2, pId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                cartItem.setCart_id(rs.getInt("cart_id"));
                cartItem.setProduct_id(rs.getInt("product_id"));
                cartItem.setQuantity(rs.getInt("quantity"));
            }
            if (cartItem.getCart_id() != null) {
                return cartItem;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean saveCartItem(CartItem cartItem, String action) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL ADD_CART_ITEM_PROC(?,?,?)";
        if (action.equals("update")) {
            sql = "CALL UPDATE_CART_ITEM(?,?,?)";
        }
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, cartItem.getCart_id());
            cs.setInt(2, cartItem.getProduct_id());
            cs.setInt(3, cartItem.getQuantity());
            int executed = cs.executeUpdate();
            return executed > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }
    @Override
    public boolean removeCartItem(Integer cartId, Integer pId) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL REMOVE_CART_ITEM_PROC(?,?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, cartId);
            cs.setInt(2, pId);
            int c = cs.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }
}
