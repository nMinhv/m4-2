package com.smartTech.service;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.model.entity.Order;
import com.smartTech.model.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    boolean creatOrder(Order order);
    boolean createOrderDetail(CartItemDto cartItem);

    boolean updateOrderDetail(OrderDetail orderDetail);
    boolean removeOrderDetail(OrderDetail orderDetail);
    List<Order> getUserOrders(Integer uid);
    Order getOrderById (Integer oid, Integer uid);
    List<OrderDetail> getOrderDetails(Integer oid);
}
