package com.osama.ecommerce.product_service.mapper;

import org.mapstruct.Mapper;

import com.osama.ecommerce.product_service.dto.ProductRequest;
import com.osama.ecommerce.product_service.dto.ProductResponse;
import com.osama.ecommerce.product_service.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toDto(Product product);
    Product toEntity(ProductRequest request);
}
