package com.smartTech.model.dao;

import com.smartTech.model.entity.Cart;
import com.smartTech.util.ConnectionDataBase;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {

    @Override
    public List<Cart> getAll() {
        return null;
    }

    @Override
    public Cart getOne(Integer id) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL GET_CART_USER(?)";
        Cart cart = new Cart();
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                cart.setCart_id(rs.getInt("cart_Id"));
                cart.setUser_id(rs.getInt("user_id"));
                cart.setTotal_price(rs.getDouble("total_price"));
                cart.setTotal_quantity(rs.getInt("total_qty"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return cart;
    }

    @Override
    public boolean updateAndSave(Cart cart) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL CREATE_CART_USER(?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, cart.getUser_id());
            int c = cs.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }


}
