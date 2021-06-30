package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.ProductDto;
import com.example.demo.model.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "title", target = "title")
    public static Product toProduct(ProductDto productDto){
        return Product.builder()
                .id(productDto.getId())
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                .build();
    }

    @InheritInverseConfiguration
    ProductDto fromProduct(Product product);

    List<Product> toProducts(List<ProductDto> productDtoList);

    List<ProductDto> fromProducts(List<Product> productList);
}