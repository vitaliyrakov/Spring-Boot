package com.example.demo.controller;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository repository;

    public CustomerController(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    @GetMapping("")
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Customer showProduct(@PathVariable("id") int id) {
        return repository.findById(id);
    }

}