package com.example.demo.controller;

import com.example.demo.controller.dto.CustomerDto;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public List<CustomerDto> showCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDto showCustomer(@PathVariable("id") int id) {
        return customerService.findById(id);
    }

}