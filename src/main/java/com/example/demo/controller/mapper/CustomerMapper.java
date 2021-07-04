package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.CustomerDto;
import com.example.demo.controller.dto.ProductDto;
import com.example.demo.model.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "name", target = "name")
    Customer toCustomer(CustomerDto customerDto);

    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);

    List<Customer> toCustomer(List<ProductDto> customerDtoList);

    List<CustomerDto> fromCustomer(List<Customer> customerList);

}
