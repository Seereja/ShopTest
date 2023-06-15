package com.example.springtest.repository.specification;

import com.example.springtest.model.Products;
import org.springframework.data.jpa.domain.Specification;

public class ProductsSpecification {

    public static Specification<Products> priceGreaterOrEqualsThan(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Products> priceLessThanOrEqualsThan(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("score"), price);
    }

    public static Specification<Products> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }
}
