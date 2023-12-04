package com.smartTech.model.dao;

import com.smartTech.model.entity.Order;
import com.smartTech.model.entity.OrderDetail;
import com.smartTech.util.ConnectionDataBase;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean createOrder(Order order) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL CREATE_ORDER_PROC(?,?,?,?,?,?,?,?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, order.getUser_id());
            cs.setDate(2, order.getDate());
            cs.setInt(3, order.getTotal_qty());
            cs.setDouble(4, order.getTotal_price());
            cs.setString(5, order.getPhone());
            cs.setString(6, order.getAddress());
            cs.setString(7, order.getEmail());
            cs.setString(8, order.getName());
            int c = cs.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }

    @Override
    public boolean saveOrderDetail(OrderDetail orderDetail, String act) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL CREATE_ORDER_DETAIL_PROC(?,?,?,?)";
        if (act.equals("update")) {
            sql = "CALL UPDATE_ORDER_DETAIL_PROC(?,?,?,?)";
        }
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, orderDetail.getOrder_id());
            cs.setInt(2, orderDetail.getOrder_id());
            cs.setInt(3, orderDetail.getQuantity());
            cs.setDouble(4, orderDetail.getSub_price());
            int c = cs.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }

    @Override
    public OrderDetail getOneDetail(Integer orderId, Integer productId) {
        OrderDetail orderDetail = new OrderDetail();
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL GET_ORDER_DETAIL_PROC(?,?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, orderId);
            cs.setInt(2, productId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                orderDetail.setOrder_id(rs.getInt("order_id"));
                orderDetail.setProduct_id(rs.getInt("product_id"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setSub_price(rs.getDouble("sub_price"));
            }
            if (orderDetail.getOrder_id() != null) {
                return orderDetail;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean removeOrderDetail(OrderDetail orderDetail) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL REMOVE_CART_ITEM_PROC(?,?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, orderDetail.getOrder_id());
            cs.setInt(2, orderDetail.getProduct_id());
            int c = cs.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }

    @Override
    public List<Order> getUserOrders(Integer uid) {
        Connection connection = ConnectionDataBase.openConnection();
        List<Order> orderList = new ArrayList<>();
        String sql = "CALL GET_USER_ORDERS_PROC(?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, uid);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrder_Id(rs.getInt("order_Id"));
                order.setUser_id(rs.getInt("user_id"));
                order.setDate(rs.getDate("order_date"));
                order.setTotal_qty(rs.getInt("total_qty"));
                order.setTotal_price(rs.getDouble("total_Price"));
                order.setPhone(rs.getString("phone"));
                order.setAddress(rs.getString("address"));
                order.setEmail(rs.getString("email"));
                order.setName(rs.getString("name"));
                order.setStatus(rs.getBoolean("status"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return orderList;
    }

    @Override
    public List<OrderDetail> getOrderDetail(Integer oid) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "CALL GET_ORDER_DETAILS_PROC(?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, oid);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder_id(rs.getInt("order_id"));
                orderDetail.setProduct_id(rs.getInt("product_id"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setSub_price(rs.getDouble("sub_price"));
                orderDetailList.add(orderDetail);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailList;
    }

}
