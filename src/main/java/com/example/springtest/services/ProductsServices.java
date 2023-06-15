package com.example.springtest.services;

import com.example.springtest.dto.ProductDto;
import com.example.springtest.exeptions.ResourseNotFoundException;
import com.example.springtest.repository.RepositoryProducts;
import com.example.springtest.model.Products;
import com.example.springtest.repository.specification.ProductsSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsServices {
    private final RepositoryProducts repositoryProducts;

    public Page<Products> findAll(Integer minPrice, Integer maxPrice, String partTitle, Integer page) {
        Specification<Products> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductsSpecification.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductsSpecification.priceLessThanOrEqualsThan(maxPrice));
        }
        if (partTitle != null) {
            spec = spec.and(ProductsSpecification.titleLike(partTitle));
        }

        return repositoryProducts.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public Optional<Products> findById(Long id) {
        return repositoryProducts.findById(id);
    }

    public void deleteById(Long id) {
        repositoryProducts.deleteById(id);
    }

    public Products save(Products products) {
        return repositoryProducts.save(products);
    }

    @Transactional
    public Products update(ProductDto productDto) throws ResourseNotFoundException {
        Products products = repositoryProducts.findById(productDto.getId()).orElseThrow(() -> new ResourseNotFoundException("" +
                "Невозможно обновить продукт, не найден в базе,id " + productDto.getId()));
        products.setPrice(productDto.getPrice());
        products.setTitle(productDto.getTitle());
        return products;
    }

//    public void changeScore(Long studentId, Integer delta) {
//        Products products = repositoryProducts.findById(studentId)
//                .orElseThrow(() -> new RuntimeException("exception:" + studentId));
//        products.setPrice(products.getPrice() + delta);
//        repositoryProducts.save(products);
//    }


}
