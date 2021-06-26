package com.example.demo.service;

import com.example.demo.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int id);

}