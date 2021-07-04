package com.example.demo.service;

import com.example.demo.controller.dto.CustomerDto;
import com.example.demo.controller.mapper.CustomerMapper;
import com.example.demo.model.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream().map(CustomerMapper.MAPPER::fromCustomer).collect(Collectors.toList());
    }

    @Override
    public CustomerDto findById(int id) {
        return customerRepository.findById(id).stream().map(CustomerMapper.MAPPER::fromCustomer).findFirst().orElse(null);
    }
}