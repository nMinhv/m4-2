package com.smartTech.controller;

import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.dto.rq.UserLoginRqDto;
import com.smartTech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    @Autowired
    UserService userService;
    @GetMapping("/login-admin")
    public String loginAdmin(Model model){
        UserLoginRqDto loginRq = new UserLoginRqDto();
        model.addAttribute("adminLogin", loginRq);
        return "admin/login";
    }
    @PostMapping("/login-admin")
    public String postLoginAdmin(@ModelAttribute("adminLogin") UserLoginRqDto loginRq, HttpServletRequest request ,
                                 RedirectAttributes redirectAttributes){
        UserLoginRpDto admin = userService.loginAdmin(loginRq);
        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("adminLogin", admin);
            return "redirect:/admin";
        }
        redirectAttributes.addFlashAttribute("error", "Wrong Password or Email");
        return "redirect:/login-admin";
    }
    @GetMapping("/logout-admin")
    public String logoutA(HttpSession session){
        if(session.getAttribute("adminLogin") != null){
            session.removeAttribute("adminLogin");
        }
        return "redirect:/login-admin";
    }
}
