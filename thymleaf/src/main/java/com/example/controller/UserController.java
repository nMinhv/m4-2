package com.example.controller;
import com.example.dto.request.UserLoginDto;
import com.example.model.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//
@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(Model model,@CookieValue(required = false,name = "email") String emailCookie){
        UserLoginDto user = new UserLoginDto();
        if(emailCookie != null){
            user.setEmail(emailCookie);
            model.addAttribute("check",true);
        }
        model.addAttribute("user",user);
        return "account/login";
    }
    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user")User user,
                            HttpSession httpSession,
                            @RequestParam(required = false, name = "check") Boolean checked,
                            HttpServletResponse response,
                            HttpServletRequest request
    ){
        User logedUser = userService.login(user);
        Cookie emailCookie = new Cookie("email", user.getEmail());

        if(checked != null){
            emailCookie.setMaxAge(24*60*60);
            response.addCookie(emailCookie);
        }else {
            emailCookie.setMaxAge(0);
            response.addCookie(emailCookie);
        }
        if(logedUser != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",logedUser.getUserName());
            return "redirect:/home";
        }
        return "redirect:/account/login";
    }
    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "account/register";
    }
    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") User user){
        userService.updateAndSave(user);
        return "redirect:/account/login";
    }
}
