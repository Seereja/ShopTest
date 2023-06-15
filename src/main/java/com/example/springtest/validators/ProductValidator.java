package com.example.springtest.validators;

import com.example.springtest.dto.ProductDto;
import com.example.springtest.exeptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    List<String> errors = new ArrayList<>();
    public void validate(ProductDto productDto) {
        if (productDto.getPrice() < 1) {
            errors.add("Цена продукта не должна быть ниже 1");
        }
        if (productDto.getTitle().isBlank()) {
            errors.add("Продукт не может иметь пустое название");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
