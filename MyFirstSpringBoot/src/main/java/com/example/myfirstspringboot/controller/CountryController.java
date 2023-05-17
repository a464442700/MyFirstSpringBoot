package com.example.myfirstspringboot.controller;

import com.example.myfirstspringboot.dto.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    // Omitted code
    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = Country.of("中国", 67);
        Country c2 = Country.of("美国", 47);
        return List.of(c1,c2);
    }
    @GetMapping("/中国")
    public ResponseEntity<Country> france() {
        Country c = Country.of("中国", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("test", "test")
                .body(c);
    }
}