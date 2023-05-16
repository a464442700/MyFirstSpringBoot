package com.example.myfirstspringboot.controller;

import com.example.myfirstspringboot.service.LoginCountService;
import com.example.myfirstspringboot.service.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginProcessor loginProcessor;
    @Autowired
    private LoginCountService loginCountService;
    @GetMapping("/")
    public String loginGet(   Model model) {
        System.out.println("get");
        int count = loginCountService.getCount();
        model.addAttribute("loginCount", count);
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model


    ) { System.out.println("post");
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        int count = loginCountService.getCount();

        if (loggedIn) {
            return "redirect:/main";
        } else {
            model.addAttribute("message", "Login failed!");
            model.addAttribute("loginCount", count);
        }
        return "login.html";
    }
}
