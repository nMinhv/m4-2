package com.smartTech.config;

import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.model.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserLoginRpDto admin = (UserLoginRpDto) session.getAttribute("adminLogin");
        if(admin != null){
            return true;
        }
        response.sendRedirect("/login-admin");
        return false;
    }
}
