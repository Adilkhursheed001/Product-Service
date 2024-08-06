package com.E_commerceBackend.E_commerceBackend.dtos;

import com.E_commerceBackend.E_commerceBackend.models.Category;
import com.E_commerceBackend.E_commerceBackend.models.ProductImage;
import com.E_commerceBackend.E_commerceBackend.models.ProductSpecification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private Category category;
    private List<ProductImage> images;
    private List<ProductSpecification> specifications;

}