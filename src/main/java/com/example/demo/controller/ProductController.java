package com.example.demo.controller;

import com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> showProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product showProduct(@PathVariable("id") int id) {
        return productService.findById(id);
    }

    @PostMapping()
    public Product create(@ModelAttribute("product") Product product) {
        product.getPrice().setDate(new Date());
        return productService.save(product);
    }

    @PostMapping("/{id}")
    public int deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return HttpStatus.OK.value();
    }
}
