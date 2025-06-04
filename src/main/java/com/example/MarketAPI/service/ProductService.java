package com.example.MarketAPI.service;

import com.example.MarketAPI.model.Product;
import com.example.MarketAPI.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product create(Product product){
        return repository.save(product);
    }

    public Product update(Long id, Product product){
        if (repository.findById(id).isEmpty()){
            throw new RuntimeException("Product not found");
        }
        product.setId(id);
        return repository.save(product);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
