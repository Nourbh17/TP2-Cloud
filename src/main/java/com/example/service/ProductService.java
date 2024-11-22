package com.example.service;

import com.example.entity.ProductsEntity; // Change to ProductEntity
import com.example.dto.ProductDto; // Change to ProductDto
import com.example.repository.ProductsRepository; // Change to ProductRepository
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException; // This can be removed if it's no longer relevant
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {  // Changed from UsersService to ProductService

    @Autowired
    private ProductsRepository productRepository;  // Changed to ProductRepository

    @SneakyThrows
    public ProductsEntity fetchProductByName(String productName){  // Changed from fetchUserByUsername to fetchProductByName
        Optional<ProductsEntity> productEntityOptional = productRepository.findByProductName(productName);  // Changed to ProductRepository method
        if (productEntityOptional.isPresent()){
            return productEntityOptional.get();
        }
        throw new AccountNotFoundException("Product with name "+productName+" not found");  // You may replace this exception with a more relevant one
    }

    public ProductsEntity addNewProduct(ProductDto productDto){  // Changed from addNewUser to addNewProduct

        log.info("Adding new product with name: " + productDto.getProductName());  // Updated log message
        ProductsEntity productEntity = new ProductsEntity();
        productEntity.setProductName(productDto.getProductName());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setCategory(productDto.getCategory());

        return productRepository.save(productEntity);  // Save the product entity to the database
    }

    public List<ProductsEntity> fetchAllProducts(){  // Changed from fetchAllUsers to fetchAllProducts
        return productRepository.findAll();  // Fetch all products
    }
}
