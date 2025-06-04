package com.example.MarketAPI.controller;

import com.example.MarketAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping
    public String getAll(){
        return "getAll";
    }

    @PostMapping
    public String create(){
        return "create";
    }

    @PutMapping
    public String update(){
        return "update";
    }

    @DeleteMapping
    public String delete(){
        return "delete";
    }
}
