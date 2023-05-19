package com.example.myfirstspringboot.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
        basePackages =  {"com.example.myfirstspringboot.proxy"})
public class ProjectConfig {
}