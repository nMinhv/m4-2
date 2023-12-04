package com.example.controller;
import com.example.model.entity.Category;
import com.example.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("")
    public String Category(Model model){
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories",list);
        return "category/index";
    }
    @RequestMapping("/add")
    public String add_category(Model model){
        Category category = new Category();
        model.addAttribute(category);
        return "category/add";
    }
    @RequestMapping("/save-category")
    public String save(@ModelAttribute("category") Category category){
        Boolean check = categoryService.saveOrUpdate(category);
        if(!check){
            return "category/add?err=''";
        }
        return "redirect:/category";
    }
    @RequestMapping("edit/{id}")
    public String edit(Model model , @PathVariable("id") int id){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
         categoryService.delete(id);
         return "redirect:/category";
    }
}
