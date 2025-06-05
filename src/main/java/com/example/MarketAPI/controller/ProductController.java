package com.example.MarketAPI.controller;

import com.example.MarketAPI.model.Product;
import com.example.MarketAPI.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id){
        Product product = service.getId(id);
        if (product!=null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Product not found in id " + id);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Product product){
        Product newProduct = service.create(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Product created on id " + newProduct.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product){
        Product newProduct = service.update(id, product);
        if (newProduct!=null){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Product updated on id " + newProduct.getId());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Product not found on id " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Product deleted on id " + id);
    }
}
