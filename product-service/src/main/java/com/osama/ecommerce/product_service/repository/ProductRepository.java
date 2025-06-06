package com.osama.ecommerce.product_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osama.ecommerce.product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);

}
