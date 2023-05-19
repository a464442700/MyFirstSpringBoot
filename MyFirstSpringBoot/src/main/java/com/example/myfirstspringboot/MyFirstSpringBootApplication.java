package com.example.myfirstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
//@ImportAutoConfiguration({FeignAutoConfiguration.class})//更换高版本openfeigin，就不需要这个注解也能正常运行
public class MyFirstSpringBootApplication {

    public static void main(String[] args){
    SpringApplication.run(MyFirstSpringBootApplication.class, args);
    }

}
