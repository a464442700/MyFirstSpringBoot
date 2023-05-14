package com.example.myfirstspringboot.service;

import com.example.myfirstspringboot.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product p) {
        products.add(p);
    }
    public List<Product> findAll() {
        return products;
    }
}