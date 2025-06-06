package com.osama.ecommerce.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.osama.ecommerce.product_service.dto.ProductRequest;
import com.osama.ecommerce.product_service.dto.ProductResponse;
import com.osama.ecommerce.product_service.entity.Product;
import com.osama.ecommerce.product_service.exception.ProductNotFoundException;
import com.osama.ecommerce.product_service.repository.ProductRepository;
import com.osama.ecommerce.product_service.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        Product saved = productRepository.save(product);
        return productMapper.toDto(saved);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));

        return productMapper.toDto(product);
    }

    public void deleteProduct(Long id) {
    if (!productRepository.existsById(id)) {
        throw new ProductNotFoundException("Product with ID " + id + " does not exist.");
    }
    productRepository.deleteById(id);
    }

}
