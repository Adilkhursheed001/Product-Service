package com.E_commerceBackend.E_commerceBackend.service;

import com.E_commerceBackend.E_commerceBackend.models.Category;
import com.E_commerceBackend.E_commerceBackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

       public Category findCategoryById(Long CategoryId){
           Optional<Category> categoryOptional = categoryRepository.findById(CategoryId);
             if(categoryOptional.isEmpty()){
                 throw new RuntimeException("Invalid Id");
             }
             else{
                 return categoryOptional.get();
             }
    }
}
