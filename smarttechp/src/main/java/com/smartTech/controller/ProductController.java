package com.smartTech.controller;

import com.smartTech.dto.rp.CartItemDto;
import com.smartTech.dto.rp.ProductDto;
import com.smartTech.dto.rp.UserLoginRpDto;
import com.smartTech.model.entity.Cart;
import com.smartTech.model.entity.CartItem;
import com.smartTech.model.entity.Category;
import com.smartTech.model.entity.Product;
import com.smartTech.service.CartItemService;
import com.smartTech.service.CartService;
import com.smartTech.service.CategoryService;
import com.smartTech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Controller

public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartService cartService;

    // user
    @GetMapping("/product-detail")
    public String productDetail(Model model
            , @RequestParam("id") Integer id) {
        ProductDto product = productService.getProductDto(id);
        if (product == null) {
            return "userview/notfound";
        }
        model.addAttribute("product", product);
        return "userview/detailProduct";

    }

    @PostMapping("/add-to-cart")
    public String addToCart(HttpSession session, HttpServletRequest request) {
        UserLoginRpDto loginUser = (UserLoginRpDto) session.getAttribute("userLogin");
        if (loginUser == null) {
            return "redirect:/login";
        }
        Integer amount = Integer.valueOf(request.getParameter("amount"));
        Integer pId = Integer.valueOf(request.getParameter("pId"));
        Cart cart = (Cart) session.getAttribute("userCart");
        if (cartItemService.addToCart(cart.getCart_id(), pId, amount)) {
            List<CartItemDto> cartItemList = cartItemService.cartItems(cart.getCart_id());
            session.setAttribute("userCartList", cartItemList);
            Cart updateCart = cartService.getOne(loginUser.getUserId());
            session.setAttribute("userCart", updateCart);
        }
        return "redirect:/user-cart";
    }

    @GetMapping("/remove-item")
    public String removeItemCart(HttpSession session, @RequestParam("id") Integer id) {
        UserLoginRpDto loginUser = (UserLoginRpDto) session.getAttribute("userLogin");
        if (loginUser == null) {
            return "redirect:/login";
        }
        Cart cart = (Cart) session.getAttribute("userCart");
        if (cartItemService.removeCartItem(cart.getCart_id(), id)) {
            List<CartItemDto> cartItemList = cartItemService.cartItems(cart.getCart_id());
            session.setAttribute("userCartList", cartItemList);
            Cart updateCart = cartService.getOne(loginUser.getUserId());
            session.setAttribute("userCart", updateCart);
            return "redirect:/user-cart";
        }
        return "userview/notfound";
    }

    // admin -------------------------------------------------------------------
    @GetMapping("/admin/product")
    public String product(Model model) {
        List<ProductDto> productsDto = productService.productsDto();
        model.addAttribute("products", productsDto);
        return "admin/product/product";
    }

    @GetMapping("/admin/add-product")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> list = categoryService.getAll();
        model.addAttribute("categories", list);
        return "admin/product/add";
    }

    @PostMapping("/admin/save-product")
    public String postAddP(@Valid @ModelAttribute("product") Product product,
                           BindingResult result, Model model,
                           HttpServletRequest request, @RequestParam("file_upload") MultipartFile file) {

        if (!result.hasErrors()) {
            if (!file.isEmpty()) {
                String img = uploadFile(request, file);
                product.setPreviewImg(img);
            }
            productService.updateAndSave(product);
            return "redirect:/admin/product";
        }
        List<Category> list = categoryService.getAll();
        model.addAttribute("categories", list);
        return "admin/product/add";
    }

    @GetMapping("/admin/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {

        return "redirect:/admin/product";
    }

    @GetMapping("/admin/edit-product/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getOne(id);
        model.addAttribute("product", product);
        List<Category> list = categoryService.getAll();
        model.addAttribute("categories", list);
        return "admin/product/add";
    }

    private String uploadFile(HttpServletRequest request, MultipartFile file) {
        // xư ly upload file lên server
        String path = request.getServletContext().getRealPath("uploads");
        String fileName = file.getOriginalFilename();
        File local = new File("C:\\Users\\aquar\\Desktop\\RA-M4-2\\smarttechp\\src\\main\\webapp\\uploads\\images\\" + fileName);
        File destination = new File(path + "/" + fileName);
        try {
            // upload lên server
            Files.write(destination.toPath(), file.getBytes(), StandardOpenOption.CREATE);
            // up vào thu mục local
            file.transferTo(local);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

}
