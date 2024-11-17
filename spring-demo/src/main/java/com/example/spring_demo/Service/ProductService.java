/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.spring_demo.Service;

/**
 *
 * @author ACER
 */
import com.example.spring_demo.Model.Customer; // Pastikan ini menggunakan yang benar
import com.example.spring_demo.Repository.CustomerRepository; // Pastikan ini menggunakan yang benar
import com.example.spring_demo.Model.Product;
import com.example.spring_demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Object getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product saveProduct(Product product) {
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Product price must be positive.");
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

