package com.example.controller;

import com.example.model.entity.Category;
import com.example.model.entity.Product;
import com.example.model.service.CategoryService;
import com.example.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("list", productService.findAll());
        return "index.jsp";
    }

    @RequestMapping("/add")
    public String add_product(Model model) {
        Product product = new Product();
        List<Category> list = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", list);
        return "product/add";
    }

    @RequestMapping("/save-product")
    public String save(@ModelAttribute("product") Product product , @RequestParam("img")MultipartFile file, HttpServletRequest request) {
        // xy ly up file
        String path =  request.getServletContext().getRealPath("upload/images");
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        File destination = new File(path + "/" + fileName);
        try {
            file.transferTo(destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImage(fileName);
        productService.saveOrUpdate(product);
        return "redirect:/product";
    }
    @RequestMapping("edit/{id}")
    public String edit(Model model , @PathVariable("id") int id){
        Product product = productService.findById(id);
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        model.addAttribute("product", product);
        return "product/edit";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/product";
    }
}
