package com.example.demo.service;

import com.example.demo.controller.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> findAll();

    CustomerDto findById(int id);

}