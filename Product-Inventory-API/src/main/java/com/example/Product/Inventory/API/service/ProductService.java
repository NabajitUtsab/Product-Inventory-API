package com.example.Product.Inventory.API.service;

import com.example.Product.Inventory.API.model.Product;
import com.example.Product.Inventory.API.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow();
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }
}
