package com.osama.ecommerce.product_service.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    private String category;

    @NotNull
    private Integer quantity;

    private String imageUrl;
}

