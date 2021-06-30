package com.example.demo.service;

import com.example.demo.controller.dto.ProductDto;
import com.example.demo.controller.mapper.ProductMapper;
import com.example.demo.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(ProductMapper.MAPPER::fromProduct).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto findById(int id) {
        return productRepository.findById(id).stream().map(ProductMapper.MAPPER::fromProduct).findFirst().orElse(null);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        productRepository.save(ProductMapper.toProduct(productDto));
        return productDto;
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

}
