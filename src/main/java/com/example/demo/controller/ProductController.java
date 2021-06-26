package com.example.demo.controller;

import com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/showAll";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "products/show";
    }

    @GetMapping("/new")
    public String addProduct(@ModelAttribute("product") Product product) {
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product) {
        product.getPrice().setDate(new Date());
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
