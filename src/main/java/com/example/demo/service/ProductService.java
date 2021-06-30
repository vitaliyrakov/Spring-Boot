package com.example.demo.service;

import com.example.demo.controller.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(int id);

    ProductDto save(ProductDto productDto);

    void delete(int id);
}
