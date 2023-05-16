package com.example.myfirstspringboot.controller;

import com.example.myfirstspringboot.service.LoggedUserManagementService;
import com.example.myfirstspringboot.service.LoginCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
//public class MainController {
//    @RequestMapping("/home")
//    public String home(Model page) {
//        page.addAttribute("username", "Katy");
//        page.addAttribute("color", "red");
//        return "home.html";
//    }
//}


//@Controller
//public class MainController {
//    @RequestMapping("/home")
//    public String home(
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String color,
//            Model page) {
//        page.addAttribute("username", name);
//        page.addAttribute("color", color);
//        return "home.html";
//    }
//}


//@Controller
//public class MainController {
//    @RequestMapping("/home/{color}")
//    public String home(
//            @PathVariable String color,
//            Model page) {
//        page.addAttribute("username", "lxf");
//        page.addAttribute("color", color);
//        return "home.html";
//    }
//}

@Controller
public class MainController {
    @Autowired
    private LoginCountService loginCountService;
    private final LoggedUserManagementService loggedUserManagementService;
    public MainController(
            LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }
    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout,Model model) {

        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }
        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();
        if (username == null) {
            return "redirect:/";//请求重定向到根路径，就会被LoginController捕捉
        }
        model.addAttribute("username" , username);
        model.addAttribute("loginCount", count);
        return "main.html";
    }
}