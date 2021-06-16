package com.example.demo.controller;

import com.example.demo.model.entity.Product;
import com.example.demo.model.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final ProductRepository productRepository;

    public TestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/new")
    public void addProduct(@RequestParam String title, @RequestParam int price) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        productRepository.save(product);
    }

    @GetMapping("/findAll")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/find")
    public Product find(@RequestParam int id) {
        return productRepository.findById(id);
    }

}
