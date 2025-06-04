package com.example.MarketAPI.controller;

import com.example.MarketAPI.model.Product;
import com.example.MarketAPI.repository.ProductRepository;
import com.example.MarketAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return service.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
