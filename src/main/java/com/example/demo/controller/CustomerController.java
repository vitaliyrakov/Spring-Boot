package com.example.demo.controller;

import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    @RolesAllowed({"ADMIN"})
    public String showCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers/showAll";
    }

    @GetMapping("/{id}")
    @RolesAllowed({"ADMIN"})
    public String showCustomer(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customers/show";
    }

}