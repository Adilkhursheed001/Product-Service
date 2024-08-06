package com.E_commerceBackend.E_commerceBackend.service;

import com.E_commerceBackend.E_commerceBackend.models.Product;
import com.E_commerceBackend.E_commerceBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

      @Autowired
      private ProductRepository productRepository;

      public Product getProductByProductId(Long ProductId){
              Optional<Product> productOptional = productRepository.findById(ProductId);
              if(productOptional.isEmpty()){
                    throw new RuntimeException("Invalid Id");
              }
              else{
                    return productOptional.get();
              }

      }

      public List<Product> getAllProduct(){
          List<Product> productList = productRepository.findAll();
          return productList;
      }
}
