package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping(value = {"/","/home"})
    public String home(HttpServletResponse response, HttpServletRequest request){
       HttpSession session =  request.getSession();
        ;
        System.out.println(session.getAttribute("user"));
        return "home";
    }
}
