package com.example.demo.controller;

import com.example.demo.controller.dto.ProductDto;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<ProductDto> showProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public  ProductDto showProduct(@PathVariable("id") int id) {
        return productService.findById(id);
    }

    @PostMapping()
    public void create(@ModelAttribute("product") ProductDto productDto) {
        productService.save(productDto);
    }

    @PostMapping("/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
    }
}
