package com.example.springtest.converters;

import com.example.springtest.dto.ProductDto;
import com.example.springtest.model.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductsConverter {
    public Products dtoToEntity(ProductDto productDto){
        return new Products(productDto.getId(),productDto.getTitle(),productDto.getPrice());
    }
    public ProductDto entityToDto(Products products){
        return new ProductDto(products.getId(), products.getTitle(), products.getPrice());
    }
}
