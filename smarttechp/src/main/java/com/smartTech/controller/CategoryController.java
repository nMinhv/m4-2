package com.smartTech.controller;

import com.smartTech.dto.rp.CategoryDto;
import com.smartTech.model.entity.Category;
import com.smartTech.service.CategoryService;
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
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String category(Model model) {
        List<CategoryDto> list = categoryService.getAllDto();
        model.addAttribute("categories",list);
        return "admin/category/category";
    }
    @GetMapping("/add-category")
    public String addCate(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        Category category = new Category();
        model.addAttribute("cate",category);
        return "admin/category/add";
    }
    @PostMapping("/add-category")
    public String postAddCate(@ModelAttribute("cate")Category category,
                              BindingResult result){
        if(!result.hasErrors()){
            categoryService.updateAndSave(category);
            return "redirect:/admin/category";
        }
        return "admin/category/add";
    }
}
