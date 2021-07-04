package com.example.demo.controller;

import com.example.demo.controller.dto.ProductDto;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

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

    @PostMapping()
    @RolesAllowed({"ADMIN", "MANAGER"})
    public String create(@ModelAttribute("product") ProductDto productDto) {
        productService.save(productDto);
        return "products/showAll";
    }

    @PostMapping("/{id}")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "products/showAll";
    }
}
