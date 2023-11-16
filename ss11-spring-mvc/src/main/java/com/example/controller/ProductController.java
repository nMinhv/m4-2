package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService = new ProductService();

    @RequestMapping("")
    public String index(Model model){
        List<Product> list = productService.getAll();
        model.addAttribute("list", list);
        return "product";
    }
    @RequestMapping("/add-product")
    public String add_product(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "add-product";
    }
    @RequestMapping("/save-product")
    public String save_product(@ModelAttribute("product")Product product){
        productService.save(product);
        return "redirect:/product";
    }
    @RequestMapping("/delete/{id}")
    public String delete_product(@PathVariable("id")int id){
        productService.delete(id);
        return "redirect:/product";
    }
    @RequestMapping("/update/{id}")
    public String update_product(@PathVariable("id")int id, Model model){
        Product product = productService.findByID(id);
        model.addAttribute("product",product);
        return "update-product";
    }
}
