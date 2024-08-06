package com.E_commerceBackend.E_commerceBackend.controller;

import com.E_commerceBackend.E_commerceBackend.dtos.ProductDto;
import com.E_commerceBackend.E_commerceBackend.models.Product;
import com.E_commerceBackend.E_commerceBackend.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductByProductId(@PathVariable("id") Long ProductId,
                                                            @RequestHeader(HttpHeaders.AUTHORIZATION) String token){

        Product product = productService.getProductByProductId(ProductId);
        ProductDto productDto = objectMapper.convertValue(product,ProductDto.class);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        return new ResponseEntity<>(productDto,headers,HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<List<ProductDto>> getAllProducts(){
        List<Product> productList = productService.getAllProduct();
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : productList){
            productDtoList.add(objectMapper.convertValue(product,ProductDto.class));
        }
        return new ResponseEntity<>(productDtoList,HttpStatus.OK);
    }
}
