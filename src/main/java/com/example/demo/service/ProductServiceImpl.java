package com.example.demo.service;

import com.example.demo.model.entity.Product;
import com.example.demo.model.repository.ProductRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(int id) {
        return productRepository.findById(id).stream().peek(it -> Hibernate.initialize(it.getCustomers())).findFirst().orElse(null);
    }

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

}
