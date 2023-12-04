package com.smartTech.controller;

import com.mysql.cj.Session;
import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.dto.rq.UserLoginRqDto;
import com.smartTech.dto.rq.UserRegisterDto;
import com.smartTech.model.entity.Cart;
import com.smartTech.model.entity.User;
import com.smartTech.service.CartItemService;
import com.smartTech.service.CartService;
import com.smartTech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/login")
    public String login(Model model) {
        UserLoginRqDto loginRqDto = new UserLoginRqDto();
        model.addAttribute("userLogin", loginRqDto);
        return "userview/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserRegisterDto registerDto = new UserRegisterDto();
        model.addAttribute("userRegister", registerDto);
        return "userview/register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("userLogin") != null) {
            session.removeAttribute("userLogin");
        }
        if (session.getAttribute("userCart") != null) {
            session.removeAttribute("userCart");
        }
        if (session.getAttribute("userCartList") != null) {
            session.removeAttribute("userCartList");
        }
        return "redirect:/";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("userLogin") UserLoginRqDto loginRqDto,
                            RedirectAttributes redirectAttributes, HttpServletResponse response,
                            HttpServletRequest request) {
        UserLoginRpDto loginUser = userService.login(loginRqDto);
        if (loginUser != null) {
            HttpSession session = request.getSession();
            Cart cart = cartService.getOne(loginUser.getUserId());
            if (cart.getCart_id() == null) {
                cart.setUser_id(loginUser.getUserId());
                cartService.updateAndSave(cart);
                cart = cartService.getOne(loginUser.getUserId());
            }
            List<CartItemDto> cartItemlist = cartItemService.cartItems(cart.getCart_id());
            session.setAttribute("userCart", cart);
            session.setAttribute("userCartList", cartItemlist);
            session.setAttribute("userLogin", loginUser);
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("error", "Wrong Password or Email");
        return "redirect:/login";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("userRegister") UserRegisterDto registerDto,
                               BindingResult result) {
        if (!result.hasErrors()) {
            User user = userService.castTo(registerDto);
            if (userService.updateAndSave(user)) {
                return "redirect:/login";
            }
        }
        return "userview/register";
    }
}
