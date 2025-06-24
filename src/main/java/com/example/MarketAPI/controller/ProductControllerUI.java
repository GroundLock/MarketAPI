package com.example.MarketAPI.controller;

import com.example.MarketAPI.model.Product;
import com.example.MarketAPI.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/ui")
public class ProductControllerUI {

    private final ProductService service;

    public ProductControllerUI(ProductService service) {
        this.service = service;
    }

    @GetMapping("/list")
    @Operation(summary = "Show all products on the DB")
    public String getAll(Model model){
        List<Product> productList= service.getAll();
        model.addAttribute("products", productList);
        return "listProducts.html";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes product in DB")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/ui/list";
    }

    @GetMapping("/product/{id}")
    @Operation(summary = "Show one specific product")
    public String getId (@PathVariable Long id, Model model){
        Product product = service.getId(id);
        if(product!=null){
            model.addAttribute("product", product);
            return "showProduct.html";
        }
        return "redirect:/ui/list";
    }

    @GetMapping("/add")
    @Operation(summary = "Opens the function to add ninjas")
    public String add (Model model){
        model.addAttribute("product", new Product());
        return "addProduct.html";
    }

    @PostMapping("/create")
    @Operation(summary = "Creates product in database")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        service.create(product);
        redirectAttributes.addFlashAttribute("message", "product created");
        return "redirect:/ui/list";
    }



}
