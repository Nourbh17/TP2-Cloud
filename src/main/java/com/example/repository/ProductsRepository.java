package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ProductsEntity;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
    Optional<ProductsEntity> findByProductName(String productName);
}
