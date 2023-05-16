package com.example.myfirstspringboot.service;

import com.example.myfirstspringboot.service.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope//@RequestScope注解可以让Spring容器在每次HTTP请求时创建一个新的Bean实例，并将其注入到相关的对象中。
public class LoginProcessor {
    private String username;
    private String password;
    @Autowired
    private final LoginCountService loginCountService;
    private final LoggedUserManagementService loggedUserManagementService;
    public boolean login() {
        loginCountService.increment();
        String username = this.getUsername();
        String password = this.getPassword();
        if ("apps".equals(username) && "123".equals(password)) {
            loggedUserManagementService.setUsername(username);
            return true;
        } else {
            return false;
        }
    }

    public LoginProcessor(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}