package com.example.myfirstspringboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope//用于指示bean的生命周期与应用程序本身一致，即在应用程序启动时创建该bean，并在应用程序关闭时销毁。且是单例模式
public class LoginCountService {
    private int count;

    public LoginCountService() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}