package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @RequestMapping("category")
    public String category() {
        return "admin/category/index";
    }

    @RequestMapping("add-category")
    public String add() {
        return "admin/category/add";
    }

    @RequestMapping("edit-category")
    public String edit() {
        return "admin/category/edit";
    }
}
