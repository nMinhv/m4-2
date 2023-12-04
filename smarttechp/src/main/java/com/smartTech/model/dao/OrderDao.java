package com.smartTech.model.dao;

import com.smartTech.model.entity.Order;
import com.smartTech.model.entity.OrderDetail;

import java.util.List;

public interface OrderDao {
    boolean createOrder(Order order);

    boolean saveOrderDetail(OrderDetail orderDetail, String act);

    OrderDetail getOneDetail(Integer orderId, Integer productId);

    boolean removeOrderDetail(OrderDetail orderDetail);
    List<Order> getUserOrders(Integer uid);
    List<OrderDetail> getOrderDetail(Integer oid);
}
