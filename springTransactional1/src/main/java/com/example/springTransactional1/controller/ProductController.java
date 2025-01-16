package com.example.springTransactional1.controller;

import com.example.springTransactional1.model.Product;
import com.example.springTransactional1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product>getProducts(){
        return service.getAllProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
          service.addProduct(product);
    }
}
