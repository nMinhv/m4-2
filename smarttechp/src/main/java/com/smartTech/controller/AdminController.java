package com.smartTech.controller;

import com.smartTech.model.entity.Category;
import com.smartTech.service.CategoryService;
import com.smartTech.service.ProductService;
import com.smartTech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    private ProductService productService;
    @GetMapping("")
    public String admin() {
        return "admin/index";
    }
    // cate

    // product

    @GetMapping("/user")
    public  String user(){
        return "admin/user/user";
    }
}
