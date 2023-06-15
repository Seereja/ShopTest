package com.example.springtest.repository;

import com.example.springtest.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryProducts extends JpaRepository<Products, Long>, JpaSpecificationExecutor<Products> {

}
