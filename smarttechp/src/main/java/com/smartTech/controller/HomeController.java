package com.smartTech.controller;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.dto.rp.ProductDto;
import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.model.entity.Cart;
import com.smartTech.model.entity.Category;
import com.smartTech.model.entity.Order;
import com.smartTech.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String homePage(Model model) {
        List<ProductDto> productsDto = productService.productsDto();
        model.addAttribute("products", productsDto);
        return "userview/homepage";
    }

    @GetMapping("/products")
    public String listProduct(Model model,
                              @RequestParam(required = false, name = "page", defaultValue = "1") Integer p) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        List<ProductDto> products = productService.productPerPage(p);
        model.addAttribute("products", products);
        List<Integer> pages = productService.findAblePage();
        model.addAttribute("pages", pages);
        model.addAttribute("cuP", p);
        return "userview/listProduct";
    }


}
