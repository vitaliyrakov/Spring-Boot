package com.example.demo.controller;

import com.example.demo.model.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> showCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer showCustomer(@PathVariable("id") int id) {
        return customerService.findById(id);
    }

}