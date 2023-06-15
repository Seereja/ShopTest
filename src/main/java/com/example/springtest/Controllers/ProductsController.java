package com.example.springtest.Controllers;

import com.example.springtest.converters.ProductsConverter;
import com.example.springtest.dto.ProductDto;
import com.example.springtest.exeptions.ResourseNotFoundException;
import com.example.springtest.model.Products;
import com.example.springtest.services.ProductsServices;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsServices productsServices;
    private final ProductsConverter converter;

    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productsServices.findAll(minPrice, maxPrice, titlePart, page).map(
                products -> converter.entityToDto(products)
        );
    }

    @GetMapping("/{id}")
    public ProductDto getProductsById(@PathVariable Long id) throws ResourseNotFoundException {
        Products products = productsServices.findById(id).orElseThrow(() -> new ResourseNotFoundException("Product not found, id: " + id));
        return converter.entityToDto(products);

    }

    @PostMapping
    public ProductDto saveNewProducts(@RequestBody ProductDto productDto) {
        Products products = converter.dtoToEntity(productDto);
        products = productsServices.save(products);
        return converter.entityToDto(products);
    }

    @PutMapping
    public ProductDto updateProducts(@RequestBody ProductDto productDto) throws ResourseNotFoundException {
        Products products =productsServices.update(productDto);
        return converter.entityToDto(products);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productsServices.deleteById(id);
    }
}
