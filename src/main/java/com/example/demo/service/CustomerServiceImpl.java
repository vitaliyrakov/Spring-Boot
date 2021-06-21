package com.example.demo.service;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.repository.CustomerRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findById(int id) {
        return customerRepository.findById(id).stream().peek(it -> Hibernate.initialize(it.getProducts())).findFirst().orElse(null);
    }
}