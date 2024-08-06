package com.E_commerceBackend.E_commerceBackend.controller;

import com.E_commerceBackend.E_commerceBackend.dtos.CategoryDto;
import com.E_commerceBackend.E_commerceBackend.models.Category;
import com.E_commerceBackend.E_commerceBackend.repository.CategoryRepository;
import com.E_commerceBackend.E_commerceBackend.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Category")
public class CategoryController {
     @Autowired
    private CategoryService categoryService;

     @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/{id}")
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long CategoryId){
         Category category = categoryService.findCategoryById(CategoryId);
         CategoryDto categoryDto = objectMapper.convertValue(category,CategoryDto.class);
         return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

     // Can i make another API for calling all categories
}
