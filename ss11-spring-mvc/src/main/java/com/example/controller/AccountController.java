package com.example.controller;
import com.example.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "/account")
public class AccountController {
    @RequestMapping("")
    public String index(){
        return "account";
    }
    @RequestMapping("/create")
    public String createAcc(Model model){
        Account account = new Account();
        model.addAttribute("account",account);
        return "create";
    }
    @RequestMapping("/storage")
    public String storage(@ModelAttribute("account") Account account){
        System.out.println("success");
        System.out.println(account.getUserName());
        System.out.println(account.getPassword());
        return "home";
    }
}