//package com.example.demo.controller;
//
//import com.example.demo.model.entity.Product;
//import com.example.demo.model.repository.ProductRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/products")
//public class ProductController {
//    private final ProductRepository productRepository;
//
//    public ProductController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @GetMapping()
//    public String showProducts(Model model) {
//        model.addAttribute("products", productRepository.findAll());
//        return "list";
//    }
//
//    @GetMapping("/{id}")
//    public String showProduct(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("product", productRepository.findById(id));
//        return "show";
//    }
//
//    @GetMapping("/new")
//    public String addProduct(Model model) {
//        Product product = new Product();
//        model.addAttribute("product", product);
//        return "new";
//    }
//
//    @PostMapping("/new")
//    public String create(Product product) {
//        productRepository.save(product);
//        return "redirect:/products";
//    }
//
//}