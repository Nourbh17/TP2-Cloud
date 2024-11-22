package com.example.controller;

import com.example.dto.ResponseDto;
import com.example.dto.ProductDto;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/fetchProductByName/{productName}")
    public ResponseEntity<?> fetchProductByNameEndpoint(@PathVariable String productName) {
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), productService.fetchProductByName(productName)));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProductEndpoint(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.value(), productService.addNewProduct(productDto)));
    }

    @GetMapping("/fetchAllProducts")
    public ResponseEntity<?> fetchAllProductsEndpoint() {
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), productService.fetchAllProducts()));
    }
}

