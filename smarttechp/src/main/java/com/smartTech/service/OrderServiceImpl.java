package com.smartTech.service;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.model.dao.OrderDao;
import com.smartTech.model.entity.Order;
import com.smartTech.model.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Override
    public boolean creatOrder(Order order) {
        java.util.Date cDate = new java.util.Date();
        Date date = new Date(cDate.getTime());
        order.setDate(date);
        return orderDao.createOrder(order);
    }

    @Override
    public boolean createOrderDetail(CartItemDto cartItem) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder_id(cartItem.getCart_id());
        orderDetail.setProduct_id(cartItem.getProduct_id());
        orderDetail.setQuantity(cartItem.getQuantity());
        orderDetail.setSub_price(cartItem.getSub_price());
        return orderDao.saveOrderDetail(orderDetail, "add");
    }

    @Override
    public boolean updateOrderDetail(OrderDetail orderDetail) {
        return orderDao.saveOrderDetail(orderDetail, "update");
    }

    @Override
    public boolean removeOrderDetail(OrderDetail orderDetail) {
        return orderDao.removeOrderDetail(orderDetail);
    }

    @Override
    public List<Order> getUserOrders(Integer uid) {
        return orderDao.getUserOrders(uid);
    }

    @Override
    public Order getOrderById(Integer oid, Integer uid) {
        List<Order> orderList = getUserOrders(uid);
        for (Order order : orderList) {
            if (order.getOrder_Id().equals(oid))
                return order;
        }
        return null;
    }

    @Override
    public List<OrderDetail> getOrderDetails(Integer oid) {
        return orderDao.getOrderDetail(oid);
    }
}
