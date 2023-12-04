package com.smartTech.controller;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.model.entity.Cart;
import com.smartTech.model.entity.Order;
import com.smartTech.model.entity.OrderDetail;
import com.smartTech.service.CartItemService;
import com.smartTech.service.CartService;
import com.smartTech.service.OrderService;
import com.smartTech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartService cartService;

    @GetMapping("/user-cart")
    public String userCart(HttpSession session) {
        return "userview/shoppingCart";
    }

    @GetMapping("/delivery-method")
    public String deliveryMethod(Model model) {
        Order order = new Order();
        model.addAttribute("userOrder", order);
        return "userview/deliveryMethod";
    }

    @GetMapping("/order-confirm")
    public String confirmOrder(HttpServletRequest request,
                               @Valid @ModelAttribute("userOrder") Order order,
                               BindingResult result) {
        if (!result.hasErrors()) {
            HttpSession session = request.getSession();
            session.setAttribute("userOrder", order);
            return "userview/confirmOrder";
        }
        return "userview/deliveryMethod";
    }

    @PostMapping("/order-confirm")
    public String postConfirmOrder(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("userCart");
        UserLoginRpDto loginRpDto = (UserLoginRpDto) session.getAttribute("userLogin");
        Order order = (Order) session.getAttribute("userOrder");
        if (loginRpDto == null) {
            return "redirect:/login";
        }
        if (cart != null && order != null) {
            order.setUser_id(loginRpDto.getUserId());
            order.setTotal_price(cart.getTotal_price());
            order.setTotal_qty(cart.getTotal_quantity());
            if (orderService.creatOrder(order)) {
                List<CartItemDto> cartItems = cartItemService.cartItems(cart.getCart_id());
                boolean c = false;
                for (CartItemDto carItem : cartItems
                ) {
                    c = orderService.createOrderDetail(carItem);
                    if (c) {
                        cartItemService.removeCartItem(carItem.getCart_id(), carItem.getProduct_id());
                    }
                    ;
                }
                if (c) {
                    cartItems.clear();
                    session.setAttribute("userCartList", cartItems);
                    Cart cartUpdate = cartService.getOne(loginRpDto.getUserId());
                    session.setAttribute("userCart", cartUpdate);
                    return "redirect:/order-history";
                }
            }
            return "userview/notfound";
        }
        return "redirect:/login";
    }

    @GetMapping("/order-history")
    public String orderHistory(Model model, HttpSession session) {
        UserLoginRpDto loginUser = (UserLoginRpDto) session.getAttribute("userLogin");
        if (loginUser == null) {
            return "redirect:/login";
        }
        List<Order> orderList = orderService.getUserOrders(loginUser.getUserId());
        model.addAttribute("orderList", orderList);
        return "userview/orderHistory";
    }

    @GetMapping("/order-detail")
    public String orderDetail(@RequestParam("id") Integer id, HttpSession session,
                              Model model) {
        UserLoginRpDto loginUser = (UserLoginRpDto) session.getAttribute("userLogin");
        if (loginUser == null) {
            return "redirect:/login";
        }
        Order order = orderService.getOrderById(id, loginUser.getUserId());
        List<OrderDetail> orderDetailList = orderService.getOrderDetails(order.getOrder_Id());
        model.addAttribute("detailList",orderDetailList);

        return "userview/oderDetail";
    }
}
