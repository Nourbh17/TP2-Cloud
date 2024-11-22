package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {  // Change the class name to ProductServiceApplication

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);  // Use the new class name
    }
}
